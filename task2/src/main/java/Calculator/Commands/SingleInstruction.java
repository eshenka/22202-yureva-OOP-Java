package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;

public interface SingleInstruction {
    public abstract void execute(String[] operands, Context context) throws CommandException;
}
