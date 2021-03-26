package parser.node.impl.literalNodes;

import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

public class LiteralNode implements Calculable {

    private final LiteralValue literalValue;

    public LiteralNode(LiteralValue literalValue) {
        this.literalValue = literalValue;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public LiteralValue calculate() {
        return literalValue;
    }
}
