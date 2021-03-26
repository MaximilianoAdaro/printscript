package parser.node.impl.operandNodes;

import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

public class SumNode extends OperandNode {

    @Override
    public LiteralValue calculate() {
//        return leftNode.calculate() + rightNode.calculate();
        return null;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
