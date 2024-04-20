package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;

public class PUSH implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) throws CommandException {
        if (operands.length != 1) {
            throw new CommandException("Provide exactly one argument for this command");
        }

        context.push(operands[0]);
    }
}
