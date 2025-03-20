package mineField;

import javax.swing.JFrame;

public class MineFieldApp {
    public static void main(String[] args) {
    MineFieldFactory factory = new MineFieldFactory();
    MineFieldPanel panel = new MineFieldPanel(factory);

    JFrame window = new JFrame("Minefield Game");
    window.setSize(500, 500);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    window.add(panel);
    window.setVisible(true);
    }
}
