package View.Observer;

import View.Event.Event;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    public final List<Observer> observers = new ArrayList<>();

    public void addObserver (Observer observer) {
        observers.add(observer);
    }

    synchronized public void notify (Event event) {
        for (Observer o : observers) {
            o.notify(event);
        }
    }
}
