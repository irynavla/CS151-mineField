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
        model.subscribe(this);
        update();
    }

    private void initView() {
        gridPanel.removeAll();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton cell = new JButton("?");
                cell.setFont(new Font("Arial", Font.PLAIN, 10));
                cell.setEnabled(false);
                cell.setBackground(Color.DARK_GRAY);
                cell.setForeground(Color.WHITE);
                gridCells[r][c] = cell;
                gridPanel.add(cell);
            }
        }
    }

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
        repaint();
    }

    public void setModel(MineFieldModel m) {
        super.setModel(m);
        this.rows = m.getRows();
        this.cols = m.getCols();
        m.subscribe(this);
        repaint();
    }
}
