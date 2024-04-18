package parser;

import io.InputReader;
import Calculator.Calculator;

public class Parser {
    String line;

    public Parser(String line) {
        this.line = line;
    }

    public String[] parse() {
        return line.split(" ");
    }
}
