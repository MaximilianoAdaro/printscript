package node.impl.literalNodes;

import node.interfaces.Calculable;
import node.interfaces.LiteralValue;
import node.visitor.NodeVisitor;

public class LiteralNode<T> implements Calculable<T> {

    private final LiteralValue<T> literalValue;

    public LiteralNode(LiteralValue<T> literalValue) {
        this.literalValue = literalValue;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public T calculate() {
        return literalValue.getValue();
    }
}
