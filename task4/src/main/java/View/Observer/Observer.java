package View.Observer;

import View.Event.Event;

public interface Observer {
    public void notify(Event event);
}
