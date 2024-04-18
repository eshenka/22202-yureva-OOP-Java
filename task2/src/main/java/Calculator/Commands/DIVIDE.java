package Calculator.Commands;

public class DIVIDE extends BinaryInstruction {
    @Override
    public Double executeOperation(Double firstOp, Double secondOp) {
        return firstOp / secondOp;
    }
}
