package Calculator.Commands;

public class PLUS extends BinaryInstruction {

    @Override
    public Double executeOperation(Double firstOp, Double secondOp) {
        return firstOp + secondOp;
    }
}
