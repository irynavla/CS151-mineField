package mineField;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineFieldPanel extends AppPanel {

    public MineFieldPanel(AppFactory factory) {
        super(factory);
        controlPanel.add(createControlPanel());
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        String[] directions = {"NW", "N", "NE", "W", "E", "SW", "S", "SE"};
        for (String dir : directions) {
            JButton button = new JButton(dir);
            button.addActionListener(e -> handleDirection(dir));
            panel.add(button);
        }

        return panel;
    }

    private void handleDirection(String direction) {
        // Example logic - modify to match your game's requirements
        System.out.println("Direction clicked: " + direction);
        // Call game logic based on the direction
    }

    // Placeholder for the actual minefield grid
    private class MineFieldGrid extends JPanel {
        public MineFieldGrid() {
            setPreferredSize(new Dimension(250, 250));
            setBackground(Color.DARK_GRAY);
        }
    }



    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();

    }
}
