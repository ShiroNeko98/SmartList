package ScreenComponents.User;

import javax.swing.*;
import java.awt.*;

public class DisplayAddedItem extends JPanel {
    public static final short width = 400;
    public static final short height = 0;
    public static final byte buttonWidth = 20;
    public static final byte buttonHeight = 20;

    private JLabel category;
    private JLabel item;
    private JLabel price;
    private QuantityField quantityField;
    private PlusButton plusButton;
    private MinusButton minusButton;

    public DisplayAddedItem(String categoryName, String itemName, String price) {
        category = new JLabel(categoryName);
        item = new JLabel(itemName);
        this.price = new JLabel(price);
        // quantityField = quantity von oben
        plusButton = new PlusButton();
        minusButton = new MinusButton();

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.GREEN);
        setLayout(new FlowLayout(FlowLayout.LEADING));
        initComponents();
    }

    public void initComponents() {
        add(category);
        add(item);
        add(price);
        add(plusButton);
        add(minusButton);
    }
}
