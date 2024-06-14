package Observation;

import Controller.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Observable {
    public final List<Observer> observers = new ArrayList<>();

    public void addObserver (Observer observer) {
        observers.add(observer);
    }

    public void notify (Event event) throws InterruptedException, IOException {
        for (Observer o : observers) {
            o.notify(event);
        }
    }
}
