package Observation;

import Controller.Event;

import java.io.IOException;

public interface Observer {
    void notify(Event event) throws InterruptedException, IOException;
}
