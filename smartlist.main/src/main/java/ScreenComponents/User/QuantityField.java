package ScreenComponents.User;

import javax.swing.*;
import java.awt.*;

public class QuantityField extends JTextField {
    private int quantity;

    public QuantityField() {
        setPreferredSize(new Dimension(50, 26));
        setHorizontalAlignment(CENTER);
    }
}
