package node.OperandNode;

import node.Calculable;

public class ProductNode<T> extends OperandNode<T> {


    public ProductNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public T calculate() {
        return null;
    }
}
