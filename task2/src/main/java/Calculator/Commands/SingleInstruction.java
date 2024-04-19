package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;
import Exceptions.ContextException;

public interface SingleInstruction {
    public abstract void execute(String[] operands, Context context) throws CommandException, ContextException;
}
