package ScreenComponents.User;

import ScreenComponents.Screen;
import ScreenComponents.SelectCategoryImpl;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    Screen screen;
    JPanel operatingPanel;
    private SelectCategoryImpl selectCategory;

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
        JComboBox comboBox = new JComboBox();
        Object[] elements = new Object[]{"Cat", "Dog", "Lion", "Mouse"};
        AutoCompleteSupport.install(comboBox, GlazedLists.eventListOf(elements));
        operatingPanel.add(comboBox);

        add(operatingPanel, "North");

    }


    void setVisibility(boolean value) {
        setVisible(value);
    }
}
