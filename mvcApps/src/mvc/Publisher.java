package mvc;
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update();
        }
    }
}
