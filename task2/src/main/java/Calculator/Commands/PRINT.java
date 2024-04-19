package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;
import Exceptions.ContextException;

import java.util.EmptyStackException;

public class PRINT implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) throws CommandException {
        if (operands.length != 0) {
            throw new CommandException("This command do not need any arguments");
        }

        try {
            System.out.println(context.peek());
        } catch (ContextException exception) {
            System.err.println(exception.getMessage());
        }

    }
}
