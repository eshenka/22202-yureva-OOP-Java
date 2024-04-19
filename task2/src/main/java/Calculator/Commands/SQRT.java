package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;
import Exceptions.ContextException;

import java.util.SplittableRandom;

import static java.lang.Math.sqrt;

public class SQRT implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) throws CommandException, ContextException {
        if (operands.length != 0) {
            throw new CommandException("This command do not need any arguments");
        }

        double value = context.pop();

        if (value < 0) {
            context.push(String.valueOf(value));
            throw new CommandException("Square root of negative number do not exist");
        }

        context.push(String.valueOf(sqrt(value)));
    }
}
