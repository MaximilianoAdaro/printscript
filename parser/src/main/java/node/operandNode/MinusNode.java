package node.operandNode;

import node.interfaces.Calculable;

public class MinusNode<T> extends OperandNode<T> {

    public MinusNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public T calculate() {
        return null;
    }
}
