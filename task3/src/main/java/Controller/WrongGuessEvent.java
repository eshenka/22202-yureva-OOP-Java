package Controller;

public class WrongGuessEvent extends Event {
    public int firstIndex;
    public int secondIndex;


    public WrongGuessEvent(String eventMessage, int firstIndex, int secondIndex) {
        super(eventMessage);

        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }
}
