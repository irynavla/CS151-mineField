package mvc;
import javax.swing.JPanel;

public abstract class View extends JPanel implements Subscriber {
    protected Model model;

    public View(Model model) {
        this.model = model;
    }

    @Override
    public void update() {
        repaint();
    }
}
