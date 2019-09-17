package ScreenComponents;

import javax.swing.*;
import java.awt.*;

public class TextFieldImpl extends JTextArea {
    public TextFieldImpl() {
        setFont(new Font("SansSerif", Font.PLAIN, 15));
        setText("");
    }
}
