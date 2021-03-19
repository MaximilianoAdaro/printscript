package node.OperandNode;

import node.Calculable;

public class MinusNode<T> extends OperandNode<T> {

    public MinusNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public T calculate() {
        return null;
    }
}
