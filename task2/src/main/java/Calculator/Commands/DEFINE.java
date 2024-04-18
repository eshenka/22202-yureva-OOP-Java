package Calculator.Commands;

import Calculator.Context;

public class DEFINE implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) {
        context.define(operands[0], Double.valueOf(operands[1]));
    }
}
