package Calculator.Commands;

public class SUB extends BinaryInstruction {

    @Override
    public Double executeOperation(Double firstOp, Double secondOp) {
        return firstOp - secondOp;
    }
}
