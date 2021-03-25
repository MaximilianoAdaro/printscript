package node.impl;

import node.interfaces.Calculable;
import node.interfaces.Declarational;
import node.interfaces.LiteralValue;
import node.visitor.NodeVisitor;

public class IdentifierNode implements Calculable, Declarational {

    private final String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public LiteralValue calculate() {
        //todo: find in all assigment the value for this identity
        return null;
    }
}
