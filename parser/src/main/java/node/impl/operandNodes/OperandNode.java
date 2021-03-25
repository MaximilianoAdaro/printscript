package node.impl.operandNodes;

import node.interfaces.Calculable;
import node.visitor.NodeVisitor;

public abstract class OperandNode implements Calculable {

    final Calculable rightNode;
    final Calculable leftNode;

    public OperandNode(Calculable rightNode, Calculable leftNode) {
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

}
