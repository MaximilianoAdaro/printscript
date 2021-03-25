package node.impl.literalNodes;

import node.interfaces.Calculable;
import node.interfaces.LiteralValue;
import node.visitor.NodeVisitor;

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
