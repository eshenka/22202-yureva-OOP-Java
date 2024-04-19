package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;
import Exceptions.ContextException;
import Exceptions.UndefinedParameterException;

import java.util.OptionalDouble;

public abstract class BinaryInstruction implements SingleInstruction {

    @Override
    public void execute(String[] operands, Context context) throws ContextException, CommandException {
        Double firstOp = context.pop();
        Double secondOp;

        try {
            secondOp = context.pop();
        } catch (ContextException exception) {
            context.push(firstOp.toString());
            throw exception;
        }

        try {
            context.push(executeOperation(firstOp, secondOp).toString());
        } catch (CommandException exception) {
            context.push(secondOp.toString());
            context.push(firstOp.toString());
            throw exception;
        }
    }

    public abstract Double executeOperation(Double firstOp, Double secondOp) throws CommandException;
}
