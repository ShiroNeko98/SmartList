package ScreenComponents;

import ScreenComponents.Admin.AdminPanel;
import ScreenComponents.User.UserPanel;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    static short width = 660;
    static short height = 540;

    private MenuBar menuBar;

    private AdminPanel adminPanel;

    private UserPanel userPanel;

    public Screen(String title) {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle(title);

        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setResizable(false);

        System.out.println("hi");

        initComponents();
    }

    private void initComponents() {
        adminPanel = new AdminPanel(this);
        userPanel = new UserPanel(this);
        menuBar = new MenuBar(this);
    }

    public AdminPanel getAdminPanel() { return adminPanel; }

    public void setAdminPanel(AdminPanel adminPanel) { this.adminPanel = adminPanel; }

    public UserPanel getUserPanel() { return userPanel; }

    public void setUserPanel(UserPanel userPanel) { this.userPanel = userPanel; }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }
}
