package mineField;

import mvc.AppFactory;
import mvc.AppPanel;
import java.awt.*;
import javax.swing.*;

import mvc.*;

public class Panel extends AppPanel {
    private JButton change;
    public Panel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this);
        controlPanel.add(change);
    }

    public static void main(String[] args) {
        AppFactory factory = new Factory();
        AppPanel panel = new Panel(factory);
        panel.display();
    }
}
