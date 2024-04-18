package Calculator.Commands;

import Calculator.Context;

public class PRINT implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) {
        System.out.println(context.peek());
    }
}
