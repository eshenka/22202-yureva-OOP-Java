package Calculator.Commands;

import Calculator.Context;

import java.util.OptionalDouble;

public abstract class BinaryInstruction implements SingleInstruction {

    @Override
    public void execute(String[] operands, Context context) {
        Double firstOp = context.pop();
        Double secondOp = context.pop();

        context.push(executeOperation(firstOp, secondOp).toString());
    }

    public abstract Double executeOperation(Double firstOp, Double secondOp);
}
