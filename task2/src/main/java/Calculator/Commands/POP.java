package Calculator.Commands;

import Calculator.Context;
import Exceptions.ContextException;

public class POP implements SingleInstruction {

    @Override
    public void execute(String[] operands, Context context) {
        try {
            context.pop();
        } catch (ContextException exception) {
            System.err.println(exception.getMessage());
        }

    }
}
