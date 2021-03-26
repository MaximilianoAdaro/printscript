package node.impl.operandNodes;

import node.interfaces.Calculable;
import node.interfaces.LiteralValue;
import node.visitor.NodeVisitor;

public class DivisionNode extends OperandNode {

    @Override
    public LiteralValue calculate() {
//        return leftNode.calculate() / rightNode.calculate();
        return null;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
