package node.impl.operandNodes;

import node.interfaces.Calculable;
import node.visitor.NodeVisitor;

public class DivisionNode<T> extends OperandNode<T> {

    public DivisionNode(Calculable<T> rightNode, Calculable<T> leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public T calculate() {
//        return leftNode.calculate() / rightNode.calculate();
        return null;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
