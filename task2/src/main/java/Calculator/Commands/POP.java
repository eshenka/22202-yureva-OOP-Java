package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;
import Exceptions.ContextException;

public class POP implements SingleInstruction {

    @Override
    public void execute(String[] operands, Context context) throws ContextException, CommandException {
        if (operands.length != 0) {
            throw new CommandException("This command do not need any arguments");
        }

        context.pop();
    }
}
