package ScreenComponents;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFileButtonImpl extends JButton implements ActionListener {
    private AdminPanel adminPanel;
    private String selectedFilePath;

    SelectFileButtonImpl(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;

        setHorizontalTextPosition(RIGHT);
        setText("SELECT FILE");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int r = fileChooser.showDialog(null, "SELECT");

        if (r == JFileChooser.APPROVE_OPTION) {
            selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            adminPanel.uploadButton.setVisible(true);
            adminPanel.uploadFile();
        }
    }

    public String getSelectedFilePath() {
        return selectedFilePath;
    }

    public void setSelectedFilePath(String selectedFilePath) {
        this.selectedFilePath = selectedFilePath;
    }
}
