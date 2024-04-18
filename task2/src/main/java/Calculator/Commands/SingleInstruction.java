package Calculator.Commands;

import Calculator.Context;

public interface SingleInstruction {
    public abstract void execute(String[] operands, Context context);
}
