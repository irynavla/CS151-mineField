package mineField;

import javax.swing.*;
import java.awt.*;

public class MineFieldPanel extends JPanel {
    public MineFieldPanel() {
        setLayout(new BorderLayout());

        // Add the control panel on the left
        add(createControlPanel(), BorderLayout.WEST);

        // Add the minefield grid or other components to the center
        add(new MineFieldGrid(), BorderLayout.CENTER);
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
            setPreferredSize(new Dimension(400, 400));
            setBackground(Color.DARK_GRAY);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mine Field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new MineFieldPanel());
        frame.setVisible(true);
    }
}
