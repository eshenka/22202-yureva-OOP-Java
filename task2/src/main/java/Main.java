import Calculator.Calculator;
import io.InputReader;
import parser.Parser;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws Exception {
//        InputReader inputReader = new InputReader("src/main/resources/test.txt");
        InputReader inputReader = new InputReader();
        Calculator calculator = new Calculator("src/main/resources/Factory.cfg");

        while (inputReader.hasNext()) {
            String input = inputReader.read();
            if (input != null) {
                Parser parser = new Parser(input);
                calculator.process(parser.parse());
            }
        }
    }
}
