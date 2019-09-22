package ScreenComponents;

import SQL.Queries;
import ScreenComponents.Admin.AdminPanel;
import ScreenComponents.User.UserPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCategoryImpl extends JComboBox implements ActionListener {
    private AdminPanel adminPanel;
    private UserPanel userPanel;
    private String selectedCategory;

    public SelectCategoryImpl() {
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        setRenderer(dlcr);

        addCategories();

        addActionListener(this);
    }

    /**
     * add all categories from db to combo-box
     */
    private void addCategories() {
        for (String categories : Queries.getAllCategories_Name()) {
            addItem(categories);
        }
        selectedCategory = getItemAt(0).toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (userPanel != null) {

        } else {
            selectedCategory = getSelectedItem().toString();
            adminPanel.getUploadButton().setVisible(true);
            adminPanel.uploadFile();
        }
    }

    public String getSelectedCategory() { return selectedCategory; }

    public void setSelectedCategory(String selectedCategory) { this.selectedCategory = selectedCategory; }

    public void setAdminPanel(AdminPanel adminPanel) { this.adminPanel = adminPanel; }

    public void setUserPanel(UserPanel userPanel) {
        this.userPanel = userPanel;

     //   selectedCategory = " ";
     //   addItem(selectedCategory);
     //   setSelectedCategory(selectedCategory);
    }

    public Object[] getAllItemNameByCategory() { return Queries.getAllItemNameByCategory(getSelectedCategory()); }
}
