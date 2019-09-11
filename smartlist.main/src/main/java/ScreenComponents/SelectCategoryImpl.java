package ScreenComponents;

import SQL.Queries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCategoryImpl extends JComboBox implements ActionListener {
    private AdminPanel adminPanel;
    private String selectedCategory;

    public SelectCategoryImpl(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;

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
        selectedCategory = getSelectedItem().toString();
        adminPanel.uploadButton.setVisible(true);
        adminPanel.uploadFile();
    }

    public String getSelectedCategory() { return selectedCategory; }

    public void setSelectedCategory(String selectedCategory) { this.selectedCategory = selectedCategory; }

    public void setAdminPanel(AdminPanel adminPanel) { this.adminPanel = adminPanel; }
}
