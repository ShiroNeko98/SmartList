package ScreenComponents.User;

import javax.swing.*;
import java.awt.*;

public class PlusButton extends JButton {

    public PlusButton() {
        setPreferredSize(new Dimension(DisplayAddedItem.buttonWidth, DisplayAddedItem.buttonHeight));

        ImageIcon icon = new ImageIcon("smartlist.main/src/main/resources/plus.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(DisplayAddedItem.buttonWidth, DisplayAddedItem.buttonHeight, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(newImg));
    }
}
