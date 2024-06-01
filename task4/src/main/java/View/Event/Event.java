package View.Event;

public abstract class Event {
    public int changedValue;

    public Event(int changedValue) {
        this.changedValue = (1 / (1 + changedValue)) * 1000;
    }
}
