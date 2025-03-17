package mineField;
import javax.swing.JOptionPane;

public class WinException extends Exception {
 public WinException() {
     super("Congratulations! You have reached the goal and won the game!");
     JOptionPane.showMessageDialog(null, getMessage(), "You Win!", JOptionPane.PLAIN_MESSAGE);
     }
}
