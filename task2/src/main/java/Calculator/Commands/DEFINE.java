package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;

public class DEFINE implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) throws CommandException {
        if (operands.length != 2) {
            throw new CommandException("Provide exactly two arguments for this command");
        }

        context.define(operands[0], Double.valueOf(operands[1]));
    }
}
