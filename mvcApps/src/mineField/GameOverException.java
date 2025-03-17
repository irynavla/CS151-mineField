package mineField;
import javax.swing.JOptionPane;

public class GameOverException extends Exception {
 public GameOverException() {
     super("Game over: No more moves allowed.");
     JOptionPane.showMessageDialog(null, getMessage(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
     }
}
