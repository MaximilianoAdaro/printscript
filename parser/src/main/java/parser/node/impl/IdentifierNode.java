package parser.node.impl;

import lombok.Data;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@Data
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
