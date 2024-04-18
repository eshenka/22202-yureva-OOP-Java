package Calculator;

import Calculator.Commands.SingleInstruction;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Calculator {
    Context context;
    CommandFactory factory;

    public Calculator(String cfgFile) throws FileNotFoundException, ClassNotFoundException {
        this.context = new Context();
        this.factory = new CommandFactory(cfgFile);
    }

    public void process(String[] tokens) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String commandName = tokens[0];

        SingleInstruction command = factory.getObject(commandName);

        command.execute(Arrays.copyOfRange(tokens, 1, tokens.length), context);
    }
}
