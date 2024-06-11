package Controller;

public class MenuEvent extends Event {
    public int difficulty;

    public MenuEvent(String eventMessage, int difficulty) {
        super(eventMessage);

        this.difficulty = difficulty;
    }
}
