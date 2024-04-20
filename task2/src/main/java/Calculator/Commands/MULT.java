package Calculator.Commands;

public class MULT extends BinaryInstruction {
    @Override
    public Double executeOperation(Double firstOp, Double secondOp) {
        return firstOp * secondOp;
    }
}
