package mineField;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class MineFieldPanel extends AppPanel {
    private JButton change;
    public MineFieldPanel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this);
        controlPanel.add(change);
    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
