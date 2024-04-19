package Calculator.Commands;

import Calculator.Context;
import Exceptions.ContextException;

import java.util.EmptyStackException;

public class PRINT implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) {
        try {
            System.out.println(context.peek());
        } catch (ContextException exception) {
            System.err.println(exception.getMessage());
        }

    }
}
