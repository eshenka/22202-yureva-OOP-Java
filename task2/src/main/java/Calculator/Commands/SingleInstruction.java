package Calculator.Commands;

import Calculator.Context;

public abstract class SingleInstruction {
    public abstract void execute(Object[] operands, Context context);
}
