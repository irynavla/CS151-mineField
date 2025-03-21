package mineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {
    private final int cellSize = 25;
    private MineFieldModel field;

    public MineFieldView(MineFieldModel model) {
        super(model);
        setLayout(new BorderLayout());

    }

    @Override
    public void setModel(Model model) {
        super.setModel(model);
        this.field = (MineFieldModel) model;
        repaint();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        int rows = field.getRows();
        int cols = field.getCols();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Default cell background
                g.setColor(Color.GRAY);
                g.fillRect(r * cellSize, c * cellSize, cellSize, cellSize);

                // Draw the cell text
                g.setColor(Color.BLACK);
                if (field.isVisited(r, c)) {
                    int neighborMines = field.getNeighborMines(r, c);
                    g.drawString(Integer.toString(neighborMines), r * cellSize + (cellSize / 2), c * cellSize + (cellSize / 2));
                } else {
                    g.drawString("?", r * cellSize + (cellSize / 2), c * cellSize + (cellSize / 2));
                }

                // Set border color
                if (field.isGoal(r, c)) {
                    g.setColor(Color.GREEN); // Goal cell border
                } else if (field.isVisited(r, c)) {
                    g.setColor(Color.WHITE); // Visited cell border
                } else {
                    g.setColor(Color.BLACK); // Not visited cell border
                }

                // Draw the border
                g.drawRect(r * cellSize, c * cellSize, cellSize, cellSize);
            }
        }
    }

}
