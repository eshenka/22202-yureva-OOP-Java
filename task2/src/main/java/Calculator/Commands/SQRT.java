package Calculator.Commands;

import Calculator.Context;

import java.util.SplittableRandom;

import static java.lang.Math.sqrt;

public class SQRT implements SingleInstruction {
    @Override
    public void execute(String[] operands, Context context) {
        double value = context.pop();
        context.push(String.valueOf(sqrt(value)));
    }
}
