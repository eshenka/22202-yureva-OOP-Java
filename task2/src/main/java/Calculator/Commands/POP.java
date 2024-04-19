package Calculator.Commands;

import Calculator.Context;
import Exceptions.ContextException;

public class POP implements SingleInstruction {

    @Override
    public void execute(String[] operands, Context context) throws ContextException {
        try {
            context.pop();
        } catch (ContextException exception) {
            throw exception;
        }
    }
}
