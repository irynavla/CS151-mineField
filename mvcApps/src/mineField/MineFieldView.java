package mineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {
    private MineFieldModel model;
    private JButton[][] gridCells;
    private int rows, cols;
    private JPanel gridPanel;

    public MineFieldView(MineFieldModel model) {
        super(model);
        this.model = model;
        this.rows = model.getRows();
        this.cols = model.getCols();
        this.gridCells = new JButton[rows][cols];

        setLayout(new BorderLayout());

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));
        add(gridPanel, BorderLayout.CENTER);

        initView();
        update();
    }

    private void initView() {
        gridPanel.removeAll();
        System.out.println("Intialized");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton cell = new JButton("?");
                if (model.isMine(r,c)){
                    cell.setText("X");
                }
                cell.setFont(new Font("Arial", Font.PLAIN, 10));
                cell.setEnabled(false);
                cell.setBackground(Color.DARK_GRAY);
                cell.setForeground(Color.WHITE);
                gridCells[r][c] = cell;
                gridPanel.add(cell);
            }
        }


    }


//TODO: fix paintComponent(). Works as intended until mvc View calls repaint(). repaint is executed by not paintComponent()
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("I've been repainted A");
        super.paintComponent(g);
        System.out.println("I've been repainted B");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton cell = gridCells[r][c];
                if (model.isVisited(r, c)) {
                    cell.setBackground(Color.LIGHT_GRAY);
                    int neighborMines = model.getNeighborMines(r, c);
                    cell.setText(Integer.toString(neighborMines));
                } else {
                    cell.setBackground(Color.DARK_GRAY);
                    cell.setText("?");
                }
            }
        }
    }


    //Temp Fix. doesn't work with file options
    @Override
    public void update() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton cell = gridCells[r][c];
                if (model.isVisited(r, c)) {
                    cell.setBackground(Color.LIGHT_GRAY);
                    int neighborMines = model.getNeighborMines(r, c);
                    cell.setText(Integer.toString(neighborMines));
                } else {
                    cell.setBackground(Color.DARK_GRAY);
                    cell.setText("?");
                }
            }
        }
    }
}
