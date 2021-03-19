package node.OperandNode;

import node.Calculable;

public abstract class OperandNode<T> implements Calculable<T> {

    private final Calculable<T> rightNode;
    private final Calculable<T> leftNode;

    public OperandNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    @Override
    public void accept() {

    }
}
