package Parser;

public class Parser {
    String line;

    public Parser(String line) {
        this.line = line;
    }

    public String[] parse() {
        return line.split(" ");
    }
}
