package ScreenComponents.Admin;

import Logger.MyLogger;
import SQL.Queries;
import ScreenComponents.TextFieldImpl;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

public class UploadButtonImpl extends JButton implements ActionListener {
    private final Logger LOG = MyLogger.getLogger(UploadButtonImpl.class.getName());

    private AdminPanel adminPanel;
    private String selectedCategory;
    private String path;

    UploadButtonImpl(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;

        setText("UPLOAD");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        long timerStart = System.currentTimeMillis();

        adminPanel.getSelectFileButton().setText("SELECT  FILE");
        adminPanel.getUploadButton().setVisible(false);

        Iterator<Row> rowIterator = null;

        File file = new File(path);
        adminPanel.getSelectFileButton().getFileChooser().setCurrentDirectory(file);    // save directory for next time
        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* importing items from file to database */
        TextFieldImpl textField = adminPanel.getTextField();
        StringBuilder str = new StringBuilder("start importing items from ");
        str.append(file.getAbsolutePath()).append(" to ").append(selectedCategory);
        textField.append(str.toString() + "\n");
        LOG.info(str.toString());

        long rowCounter = 0;
        while (rowIterator != null && rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell itemName = row.getCell(0);
            Cell itemPrice = row.getCell(1);

            String itemNameStr = itemName.toString();
            if (!itemNameStr.equals("ITEM_NAME")) {
                rowCounter++;
                Queries.setTextField(textField);
                Queries.insertItem(selectedCategory, itemNameStr, Double.valueOf(itemPrice.toString()));
            }
        }

        if (Queries.failCounter == 0) {

            LOG.info("successfully imported " + rowCounter + " items; " +
                     DurationFormatUtils.formatDurationHMS(System.currentTimeMillis() - timerStart));
        } else {
            LOG.info("failed to import " + Queries.failCounter + " items out of " + rowCounter + "; " +
                     DurationFormatUtils.formatDurationHMS(System.currentTimeMillis() - timerStart));
            Queries.failCounter = 0;
        }
    }

    void setUploadPanelVisible(boolean value) {
        setVisible(value);
    }

    public String getSelectCategory() { return selectedCategory; }

    public void setSelectCategory(String selectCategory) { this.selectedCategory = selectCategory; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }
}
