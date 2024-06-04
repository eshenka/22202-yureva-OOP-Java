package Model;

public class Card {
    public enum State {
        OPENED,
        CLOSED
    }

    State state;
    String image;

    public Card (String image) {
        this.state = State.CLOSED;
        this.image = image;
    }

    public State getState() {
        return state;
    }

    boolean isClosed() {
        return state == State.CLOSED;
    }

    boolean isOpened() {
        return state == State.OPENED;
    }

    public String getImage() {
        return image;
    }
}
