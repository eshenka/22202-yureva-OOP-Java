import Calculator.Calculator;
import Exceptions.ContextException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class DEFINETest {
    private Calculator calculator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() throws FileNotFoundException, ClassNotFoundException {
        calculator = new Calculator("src/main/resources/Factory.cfg");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDefine() throws Exception {
        calculator.process(new String[]{"PUSH", "5"});
        calculator.process(new String[]{"PUSH", "a"});

        calculator.process(new String[]{"DEFINE", "a", "8"});

        calculator.process(new String[]{"MULT"});

        calculator.process(new String[]{"PRINT"});

        Assert.assertEquals("40.0", outContent.toString().trim());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}