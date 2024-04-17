package Calculator.Commands;

import Calculator.Context;

import java.util.OptionalDouble;

public abstract class BinaryInstruction extends SingleInstruction {

    @Override
    public void execute(Object[] operands, Context context) {
        Double firstOp = context.pop();
        Double secondOp = context.pop();

        context.push(executeOperation(firstOp, secondOp));
    }

    public abstract Double executeOperation(Double firstOp, Double secondOp);
}
