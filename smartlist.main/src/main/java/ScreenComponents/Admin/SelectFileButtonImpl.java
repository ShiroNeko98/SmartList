package ScreenComponents.Admin;

import ScreenComponents.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFileButtonImpl extends JButton implements ActionListener {
    private AdminPanel adminPanel;
    private Screen screen;
    private String selectedFilePath;
    private JFileChooser fileChooser;

    SelectFileButtonImpl(AdminPanel adminPanel, Screen screen) {
        this.adminPanel = adminPanel;
        this.screen = screen;

        setHorizontalTextPosition(RIGHT);
        setText("SELECT  FILE");
        setPreferredSize(new Dimension((int) (screen.getWidth() * 0.6), 25));
        fileChooser = new JFileChooser();
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int r = fileChooser.showDialog(null, "SELECT");

        if (r == JFileChooser.APPROVE_OPTION) {
            selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            setText(selectedFilePath);
            adminPanel.getUploadButton().setVisible(true);
            adminPanel.uploadFile();

            /* cut of right parts of too long file-paths in order to show file name */
            if (getText().length() > 52) {
                String pathDisplay = getText();
                while (pathDisplay.length() > 52 || pathDisplay.charAt(0) != '\\') {
                    pathDisplay = pathDisplay.substring(1);
                }
                setText(getText().charAt(0) + ":\\ ... " + pathDisplay);
            }
        }
    }

    public String getSelectedFilePath() {
        return selectedFilePath;
    }

    public void setSelectedFilePath(String selectedFilePath) {
        this.selectedFilePath = selectedFilePath;
    }

    public JFileChooser getFileChooser() { return fileChooser; }

    public void setFileChooser(JFileChooser fileChooser) { this.fileChooser = fileChooser; }
}
