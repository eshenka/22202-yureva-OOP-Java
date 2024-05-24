package View.Event;

public abstract class Event {
    public int changedValue;

    public Event(int changedValue) {
        this.changedValue = 26000 - changedValue * 1000;
    }
}
