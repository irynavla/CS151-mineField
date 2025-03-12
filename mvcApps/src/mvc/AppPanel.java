package mvc;
import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel {
    protected ControlPanel controlPanel;
    protected View view;

    public AppPanel(View view) {
        this.view = view;
        this.controlPanel = new ControlPanel();
        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    // Nested class inside AppPanel
    public class ControlPanel extends JPanel {
        public ControlPanel() {
            JButton button = new JButton("Click Me");
            add(button);
        }
    }
}
