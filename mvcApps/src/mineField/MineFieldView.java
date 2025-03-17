package mineField;

import mvc.View;
import java.awt.*;

public class MineFieldView extends View {
    private static final int CELL_SIZE = 30;

    public MineFieldView(MineFieldModel model) {
        super(model);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        MineFieldModel field = (MineFieldModel) model;

        for (int r = 0; r < field.getRows(); r++) {
            for (int c = 0; c < field.getCols(); c++) {
                if (field.isMine(r, c)) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Draw player
        g.setColor(Color.BLUE);
        g.fillOval(field.getPy() * CELL_SIZE, field.getPx() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}
