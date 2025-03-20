package mvc;
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    public List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s){
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s){
        subscribers.remove(s);
    }

    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            System.out.println(s);
            s.update();
            System.out.println("Notified");
        }
    }
}
