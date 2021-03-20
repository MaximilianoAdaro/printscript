package node.impl.operandNodes;

import node.interfaces.Calculable;
import node.visitor.NodeVisitor;

public abstract class OperandNode<T> implements Calculable<T> {

    final Calculable<T> rightNode;
    final Calculable<T> leftNode;

    public OperandNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

}
