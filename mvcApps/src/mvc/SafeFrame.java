package mvc;
import javax.swing.*;

public class SafeFrame extends JFrame {
    public SafeFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }
}
