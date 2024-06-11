package Model;

public class Pair {
    String string;
    Integer integer;

    public Pair(String string, Integer integer) {
        this.string = string;
        this.integer = integer;
    }

    public String first() {
        return string;
    }

    public Integer second() {
        return integer;
    }
}
