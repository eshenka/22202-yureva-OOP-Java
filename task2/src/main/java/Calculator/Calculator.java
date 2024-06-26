package Calculator;

import Calculator.Commands.SingleInstruction;
import Exceptions.CommandException;
import Exceptions.ContextException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Calculator {
    Context context;
    CommandFactory factory;

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public Calculator(String cfgFile) throws IOException, ClassNotFoundException {
        this.context = new Context();
        this.factory = new CommandFactory(cfgFile);
    }

    public void process(String[] tokens) throws Exception {
        String commandName = tokens[0];

        SingleInstruction command = factory.getObject(commandName);

        try {
            command.execute(Arrays.copyOfRange(tokens, 1, tokens.length), context);
            logger.info("Executed command " + commandName);
        } catch (CommandException | ContextException exception) {
            logger.error("Failed to execute " + commandName + ". Error message: " + exception.getMessage());
            throw exception;
        }

    }
}
