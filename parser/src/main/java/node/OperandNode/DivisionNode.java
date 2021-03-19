package node.OperandNode;

import node.Calculable;

public class DivisionNode<T> extends OperandNode<T> {


    public DivisionNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public T calculate() {
        return null;
    }
}
