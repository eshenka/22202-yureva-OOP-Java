package Calculator.Commands;

import Exceptions.CommandException;

public class DIVIDE extends BinaryInstruction {
    @Override
    public Double executeOperation(Double firstOp, Double secondOp) throws CommandException {
        if (secondOp == 0) {
            throw new CommandException("Division by zero");
        }


        System.out.println("Divide "+firstOp+" by "+secondOp);
        return firstOp / secondOp;
    }
}
