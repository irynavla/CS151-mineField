package mvc;
import javax.swing.JPanel;

public class View extends JPanel implements Subscriber {
    protected Model model;

    public View(Model model) {
        this.model = model;
        System.out.println("Subscribed");
        this.model.subscribe(this);
        update();
    }

    public void setModel(Model model) {
        this.model.unsubscribe(this);
        this.model = model;
        this.model.subscribe(this);
        update();
    }

    public void update() {
        System.out.println("Starting Repaint");
        repaint();
    }
}
