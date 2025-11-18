package subscribe;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String name;
    private List<Observer> observers;

    public Channel(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifySubscribers(String message) {
        String finalMessage = "[" + name + "] " + message;
        for (Observer observer : observers) {
            observer.update(finalMessage);
        }
    }

    public String getName() {
        return name;
    }
    
}
