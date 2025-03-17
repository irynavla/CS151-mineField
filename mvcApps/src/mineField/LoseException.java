package mineField;
import javax.swing.JOptionPane;

public class LoseException extends Exception {
 public LoseException() {
     super("Boom! You stepped on a mine. Game over.");
     JOptionPane.showMessageDialog(null, getMessage(), "You Lose!", JOptionPane.ERROR_MESSAGE);
     }
}
