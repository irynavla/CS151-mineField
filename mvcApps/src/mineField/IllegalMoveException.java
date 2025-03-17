package mineField;
import javax.swing.JOptionPane;

public class IllegalMoveException extends Exception {
 public IllegalMoveException() {
     super("Illegal move: You are trying to move out of bounds!");
     JOptionPane.showMessageDialog(null, getMessage(), "Illegal Move", JOptionPane.WARNING_MESSAGE);
     }
}