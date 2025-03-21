package mineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MineFieldPanel extends AppPanel {
    public MineFieldPanel(AppFactory factory) {
        super(factory);
        setLayout(new BorderLayout());

        add(view, BorderLayout.CENTER);

        JPanel p = new JPanel();
        add(p, "North");
        JPanel keys = new JPanel(); //the keys format
        keys.setLayout(new GridLayout(4, 2));

        for (Heading h : Heading.values()) {
            JButton b = new JButton(h.name());
            p = new JPanel();
            p.add(b);
            keys.add(p);
            b.addActionListener(this);
        add(keys, BorderLayout.WEST);
        }
    }
    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
