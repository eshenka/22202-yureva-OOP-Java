import Calculator.Calculator;
import Exceptions.ContextException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class DIVIDETest {
    private Calculator calculator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() throws FileNotFoundException, ClassNotFoundException {
        calculator = new Calculator("src/main/resources/Factory.cfg");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDivide() throws Exception {
        calculator.process(new String[]{"PUSH", "5"});
        calculator.process(new String[]{"PUSH", "25"});

        calculator.process(new String[]{"DIVIDE"});

        calculator.process(new String[]{"PRINT"});

        Assert.assertEquals("5.0", outContent.toString().trim());
    }

    @Test(expected = ContextException.class)
    public void testDivideException() throws Exception {
        calculator.process(new String[]{"PUSH", "0"});
        calculator.process(new String[]{"PUSH", "5"});

        calculator.process(new String[]{"DIVIDE"});
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}