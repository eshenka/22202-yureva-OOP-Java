package Controller;

public class GuessClickEvent extends Event {
    public int source;
    public GuessClickEvent (String eventMessage, int source) {
        super(eventMessage);

        this.source = source;
    }
}
