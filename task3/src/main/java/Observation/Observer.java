package Observation;

import Controller.Event;

public interface Observer {
    public void notify(Event event);
}
