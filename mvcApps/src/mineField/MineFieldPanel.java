package mineField;

import mvc.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineFieldPanel extends JPanel implements ActionListener {

    public MineFieldPanel() {
        setLayout(new BorderLayout());

        // Add the control panel on the left with a specific preferred width
        JPanel controlPanel = createControlPanel();
        controlPanel.setPreferredSize(new Dimension(250, getHeight())); // Set preferred width to 150px
        add(controlPanel, BorderLayout.WEST);

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
            setPreferredSize(new Dimension(250, 250));
            setBackground(Color.DARK_GRAY);
        }
    }

    // Create the menu bar
    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // Add file, edit, and help menus
        JMenu fileMenu = Utilities.makeMenu("File", new String[] {"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu = Utilities.makeMenu("Edit", new String[] {"Undo", "Redo"}, this); // Adjust based on your commands
        result.add(editMenu);

        JMenu helpMenu = Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);

        return result;
    }

    // ActionListener method to handle menu actions
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                System.out.println("New game started");
                // Handle New action
                break;
            case "Save":
                System.out.println("Game saved");
                // Handle Save action
                break;
            case "SaveAs":
                System.out.println("Save As invoked");
                // Handle SaveAs action
                break;
            case "Open":
                System.out.println("Open game");
                // Handle Open action
                break;
            case "Quit":
                System.out.println("Quit game");
                // Handle Quit action
                break;
            case "Undo":
                System.out.println("Undo action");
                // Handle Undo action
                break;
            case "Redo":
                System.out.println("Redo action");
                // Handle Redo action
                break;
            case "About":
                System.out.println("About game");
                // Handle About action
                break;
            case "Help":
                System.out.println("Help section");
                // Handle Help action
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mine Field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);

        // Create MineFieldPanel and add it to the frame
        MineFieldPanel panel = new MineFieldPanel();
        frame.add(panel);

        // Set the menu bar
        frame.setJMenuBar(panel.createMenuBar());

        frame.setVisible(true);
    }
}
