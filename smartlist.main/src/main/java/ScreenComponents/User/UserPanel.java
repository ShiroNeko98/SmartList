package ScreenComponents.User;

import ScreenComponents.Screen;
import ScreenComponents.SelectCategoryImpl;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    private Screen screen;
    private JPanel operatingPanel;
    private SelectCategoryImpl selectCategory;
    private JComboBox itemList;
    private QuantityField quantityField;
    private AddButton addButton;

    private JScrollPane scrollPane;
    private UserViewItemPanel userViewItemPanel;

    public UserPanel(Screen screen) {
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
        selectCategory.setUserPanel(this);
        operatingPanel.add(selectCategory);

        /* */
        itemList = new JComboBox();
        AutoCompleteSupport.install(itemList, GlazedLists.eventListOf(selectCategory.getAllItemNameByCategory()));
        operatingPanel.add(itemList);

        /* quantity field */
        quantityField = new QuantityField();
        operatingPanel.add(quantityField);

        /* add button */
        addButton = new AddButton(this);
        operatingPanel.add(addButton);

        add(operatingPanel, "North");

        scrollPane = new JScrollPane();
        userViewItemPanel = new UserViewItemPanel();

        add(scrollPane);

    }

    public void update(DisplayAddedItem displayAddedItem) {
        userViewItemPanel.addItemPanel(displayAddedItem);

        JViewport viewport = scrollPane.getViewport();
        try {
            viewport.getComponent(0);
            viewport.remove(0);
        } catch (IndexOutOfBoundsException e) {}
        viewport.add(userViewItemPanel);
    }

    public String getSelectCategory() { return selectCategory.getSelectedItem().toString(); }

    public String getSelectedItem() { return itemList.getSelectedItem().toString(); }

    public String getQuantity() { return quantityField.getText(); }

    void setVisibility(boolean value) {
        setVisible(value);
    }
}
