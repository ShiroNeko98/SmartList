package ScreenComponents.User;

import SQL.Queries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton extends JButton implements ActionListener {
    private UserPanel userPanel;
    private DisplayAddedItem displayAddedItem;

    public AddButton(UserPanel userPanel) {
        this.userPanel = userPanel;
        addActionListener(this);
        setText("ADD");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String categoryName = userPanel.getSelectCategory();
        String itemName = userPanel.getSelectedItem();
        String itemPrice = Queries.findPriceForItem(categoryName, itemName).toString();
        displayAddedItem = new DisplayAddedItem(categoryName, itemName, itemPrice);
        userPanel.update(displayAddedItem);
    }
}
