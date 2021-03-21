package node.impl;

import node.interfaces.Calculable;
import node.interfaces.Declarational;
import node.visitor.NodeVisitor;

public class IdentifierNode<T> implements Calculable<T>, Declarational {

    private final String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public T calculate() {
        return null;
    }
}
