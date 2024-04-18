package Calculator.Commands;

import Calculator.Context;

public class POP implements SingleInstruction {

    @Override
    public void execute(String[] operands, Context context) {
        context.pop();
    }
}
