package ScreenComponents;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    private Screen screen;
    private JPanel operatingPanel;
    private SelectCategoryImpl selectCategory;
    private SelectFileButtonImpl selectFileButton;
    private UploadButtonImpl uploadButton;

    AdminPanel(Screen screen) {
        this.screen = screen;

        setLayout(new BorderLayout());

        initComponents();
    }

    private void initComponents() {
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap((int) (screen.getHeight() * 0.1));
        operatingPanel = new JPanel(flowLayout);
        operatingPanel.setBackground(Color.CYAN);

        selectCategory = screen.getSelectCategory();
        selectFileButton = screen.getSelectFile();

        operatingPanel.add(selectCategory);
        operatingPanel.add(selectFileButton);

        add(operatingPanel, "North");

        /* TODO show Log-Messages */
        JTextField textField = new JTextField("hi");
        textField.setEditable(false);
        textField.setBackground(Color.RED);
        add(textField);
    }

    public SelectFileButtonImpl getSelectFileButton() { return selectFileButton; }

    public void setSelectFileButton(String selectedFilePath) {
        int buttonHeight = selectFileButton.getHeight();
        selectFileButton.setPreferredSize(new Dimension((int) (screen.getWidth() * 0.6), buttonHeight));

        // TODO the file name should be seen at all time
        selectFileButton.setText(selectedFilePath);

        uploadButton = new UploadButtonImpl();
        uploadButton.setSelectCategory(selectCategory.getSelectedItem().toString());
        uploadButton.setPath(selectedFilePath);
        operatingPanel.add(uploadButton);
    }
}
