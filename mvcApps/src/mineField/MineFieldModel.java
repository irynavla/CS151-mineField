package mineField;
import java.io.Serializable;
import java.util.*;
import mvc.Model;

public class MineFieldModel extends Model {
	private int rows, cols;
	private Cell[][] grid;
	private static int percentMined = 5;
	private int px, py;
	private boolean gameOver;

	public MineFieldModel(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.grid = new Cell[rows][cols];
		initializeGrid();
	}


	private class Cell implements Serializable {
        boolean isMined;
        boolean isVisited;
        int neighborMines;

        Cell() {
            isMined = false;
            isVisited = false;
            neighborMines = 0;
        }

    }

	public void initializeGrid() {
		Random rand = new Random();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell();
                if (rand.nextInt(100) < percentMined) {
                    grid[r][c].isMined = true;
                }
            }
        }
		this.px = 0;
		this.py = 0;
		this.gameOver = false;
		this.grid[px][py].isVisited = true;
		for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c].neighborMines = getNeighborMines(r, c);
            }
        }
		changed();
	}

	public boolean isVisited(int row, int col) {
		return this.grid[row][col].isVisited;
	}

	public boolean isGoal(int row, int col) {
		return row == this.rows - 1 && col == this.cols - 1;
	}

	public int getNeighborMines(int row, int col) {
		int total = 0;
		for (Heading h : Heading.values()) {
			int newRow = row + h.getDx();
			int newCol = col + h.getDy();

			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
				if (grid[newRow][newCol].isMined) {
					total++;
				}
			}
		}
		return total;
	}

	public boolean isMine(int row, int col) {
		return this.grid[row][col].isMined;
	}

	public void move(Heading h) throws GameOverException, IllegalMoveException, WinException, LoseException {
		if (gameOver) {
            throw new GameOverException();
        }

		int newX = this.px + h.getDx();
		int newY = this.py + h.getDy();
		if (newX < 0 || newX >= this.rows || newY < 0 || newY >= this.cols) {
			throw new IllegalMoveException();
		}

		this.px = newX;
		this.py = newY;

		if (this.px == this.rows - 1 && this.py == this.cols - 1) {
			gameOver = true;
			changed();
			throw new WinException();
		}
		if (isMine(this.px, this.py)) {
			gameOver = true;
			changed();
			throw new LoseException();
		}

		this.grid[this.px][this.py].isVisited = true;
		changed();
	}

	public int getPx() {
		return this.px;
	}
	public int getPy() {
		return this.py;
	}
	public int getRows() {
		return this.rows;
	}
	public int getCols() {
		return this.cols;
	}

	public void resetGame() {
		initializeGrid();
	}

}
