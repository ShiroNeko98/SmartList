package ScreenComponents.Admin;

import ScreenComponents.Screen;
import ScreenComponents.SelectCategoryImpl;
import ScreenComponents.TextFieldImpl;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    private Screen screen;
    JPanel operatingPanel;
    private SelectCategoryImpl selectCategory;
    private SelectFileButtonImpl selectFileButton;
    private UploadButtonImpl uploadButton;
    public static TextFieldImpl textField;

    public AdminPanel(Screen screen) {
        this.screen = screen;

        setLayout(new BorderLayout());

        initComponents();
    }

    private void initComponents() {
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap((int) (screen.getHeight() * 0.05));
        operatingPanel = new JPanel(flowLayout);
        operatingPanel.setBackground(Color.CYAN);

        /* select category */
        selectCategory = new SelectCategoryImpl();
        selectCategory.setAdminPanel(this);
        operatingPanel.add(selectCategory);

        /* select file */
        selectFileButton = new SelectFileButtonImpl(this, screen);
        operatingPanel.add(selectFileButton);

        uploadButton = new UploadButtonImpl(this);

        add(operatingPanel, "North");

        textField = new TextFieldImpl();
        JScrollPane scrollPane = new JScrollPane(textField);
        add(scrollPane);
    }

    public SelectFileButtonImpl getSelectFileButton() { return selectFileButton; }

    public void uploadFile() {
        uploadButton.setSelectCategory(selectCategory.getSelectedCategory());
        uploadButton.setPath(selectFileButton.getSelectedFilePath());
        operatingPanel.add(uploadButton);
    }

    public UploadButtonImpl getUploadButton() { return uploadButton; }

    public void setUploadButton(UploadButtonImpl uploadButton) { this.uploadButton = uploadButton; }

    public TextFieldImpl getTextField() { return textField; }

    public void setTextField(TextFieldImpl textField) { this.textField = textField; }
}
