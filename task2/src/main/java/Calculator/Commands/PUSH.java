package Calculator.Commands;

import Calculator.Context;

public class PUSH implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) {
        context.push(operands[0]);
    }
}
