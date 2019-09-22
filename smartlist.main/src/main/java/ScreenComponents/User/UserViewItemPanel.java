package ScreenComponents.User;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class UserViewItemPanel extends JPanel {

    public UserViewItemPanel() {
        //   setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new MigLayout("debug, alignx center"));

        //  setLayout(new GridBagLayout());
    }

    public void addItemPanel(DisplayAddedItem item) {
        add(item, "wrap");
    }
}
