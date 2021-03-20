package node.operandNode;

import node.interfaces.Calculable;

public class DivisionNode<T> extends OperandNode<T> {


    public DivisionNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public T calculate() {
        return null;
    }
}
