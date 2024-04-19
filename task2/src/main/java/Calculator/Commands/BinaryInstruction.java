package Calculator.Commands;

import Calculator.Context;
import Exceptions.CommandException;
import Exceptions.ContextException;

import java.util.OptionalDouble;

public abstract class BinaryInstruction implements SingleInstruction {

    @Override
    public void execute(String[] operands, Context context) throws ContextException {
        try {
            Double firstOp = context.pop();
            Double secondOp = context.pop();

            try {
                context.push(executeOperation(firstOp, secondOp).toString());
            } catch (CommandException exception) {
                context.push(secondOp.toString());
                context.push(firstOp.toString());
                throw exception;
            }
        } catch (ContextException | CommandException exception) {
//            System.err.println(exception.getMessage());
            throw new ContextException(exception.getMessage());
        }
    }

    public abstract Double executeOperation(Double firstOp, Double secondOp) throws CommandException;
}
