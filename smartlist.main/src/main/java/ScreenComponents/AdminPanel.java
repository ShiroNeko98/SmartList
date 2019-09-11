package ScreenComponents;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    private Screen screen;
    JPanel operatingPanel;
    private SelectCategoryImpl selectCategory;
    private SelectFileButtonImpl selectFileButton;
    UploadButtonImpl uploadButton;

    AdminPanel(Screen screen) {
        this.screen = screen;

        setLayout(new BorderLayout());

        initComponents();
    }

    private void initComponents() {
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap((int) (screen.getHeight() * 0.1));   // TODO gap too big
        operatingPanel = new JPanel(flowLayout);
        operatingPanel.setBackground(Color.CYAN);

        /* select category */
        selectCategory = new SelectCategoryImpl(this);
        selectCategory.setAdminPanel(this);
        operatingPanel.add(selectCategory);

        /* select file */
        selectFileButton = new SelectFileButtonImpl(this, screen);
        operatingPanel.add(selectFileButton);

        uploadButton = new UploadButtonImpl(this);

        add(operatingPanel, "North");

        /* TODO show Log-Messages */
        JTextField textField = new JTextField("hi");
        textField.setEditable(false);
        textField.setBackground(Color.RED);
        add(textField);
    }

    public SelectFileButtonImpl getSelectFileButton() { return selectFileButton; }

    public void uploadFile() {
        uploadButton.setSelectCategory(selectCategory.getSelectedCategory());
        uploadButton.setPath(selectFileButton.getSelectedFilePath());
        operatingPanel.add(uploadButton);
    }
}
