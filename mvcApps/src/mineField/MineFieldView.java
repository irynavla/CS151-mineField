package mineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {
    private MineFieldModel model;
    private JButton[][] gridCells;
    private int rows, cols;
    private JPanel gridPanel;
    private final int cellSize = 40;
    public MineFieldView(MineFieldModel model) {
        super(model);
        this.model = model;
        this.rows = model.getRows();
        this.cols = model.getCols();
//        this.gridCells = new JButton[rows][cols];

        setLayout(new BorderLayout());

//        gridPanel = new JPanel();
//        gridPanel.setLayout(new GridLayout(rows, cols));
//        add(gridPanel, BorderLayout.CENTER);

        initView();
//        update();
    }

    private void initView() {
//        gridPanel.removeAll();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

//                JButton cell = new JButton("?");
                if (model.isMine(r,c)){
//                    cell.setText("X");
                }
//                cell.setFont(new Font("Arial", Font.PLAIN, 10));
//                cell.setEnabled(false);
//                cell.setBackground(Color.DARK_GRAY);
//                cell.setForeground(Color.WHITE);
//                gridCells[r][c] = cell;
//                gridPanel.add(cell);
            }
        }


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 10));

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Default cell background
                g.setColor(Color.GRAY);
                g.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);

                // Draw the cell text
                g.setColor(Color.BLACK);
                if (model.isVisited(r, c)) {
                    int neighborMines = model.getNeighborMines(r, c);
                    g.drawString(Integer.toString(neighborMines), c * cellSize + (cellSize / 2), r * cellSize + (cellSize / 2));
                } else {
                    g.drawString("?", c * cellSize + (cellSize / 2), r * cellSize + (cellSize / 2));
                }

                // Set border color
                if (model.isGoal(r, c)) {
                    g.setColor(Color.GREEN); // Goal cell border
                } else if (model.isVisited(r, c)) {
                    g.setColor(Color.WHITE); // Visited cell border
                } else {
                    g.setColor(Color.BLACK); // Not visited cell border
                }

                // Draw the border
                g.drawRect(c * cellSize, r * cellSize, cellSize, cellSize);
            }
        }
    }




    //Temp Fix. doesn't work with file options
//    @Override
//    public void update() {
//        for (int r = 0; r < rows; r++) {
//            for (int c = 0; c < cols; c++) {
//                JButton cell = gridCells[r][c];
//                if (model.isVisited(r, c)) {
//                    cell.setBackground(Color.LIGHT_GRAY);
//                    int neighborMines = model.getNeighborMines(r, c);
//                    cell.setText(Integer.toString(neighborMines));
//                } else {
//                    cell.setBackground(Color.DARK_GRAY);
//                    cell.setText("?");
//                }
//            }
//        }
//    }
}
