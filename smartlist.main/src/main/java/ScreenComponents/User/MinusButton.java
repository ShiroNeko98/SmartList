package ScreenComponents.User;

import javax.swing.*;
import java.awt.*;

public class MinusButton extends JButton {

    public MinusButton() {
        setPreferredSize(new Dimension(DisplayAddedItem.buttonWidth, DisplayAddedItem.buttonHeight));

        ImageIcon icon = new ImageIcon("smartlist.main/src/main/resources/minus.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(DisplayAddedItem.buttonWidth, DisplayAddedItem.buttonHeight, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(newImg));
    }
}
