package node.OperandNode;

import node.Calculable;

public class SumNode<T> extends OperandNode<T> {

    public SumNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public T calculate() {
        return null;
    }
}
