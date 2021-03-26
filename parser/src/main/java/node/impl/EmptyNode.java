package node.impl;

import node.impl.literalNodes.TypeValue;
import node.interfaces.Calculable;
import node.interfaces.LiteralValue;
import node.visitor.NodeVisitor;

public class EmptyNode implements Calculable {

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public LiteralValue calculate() {
        return new LiteralValue() {
            @Override
            public Object getValue() {
                return "";
            }

            @Override
            public TypeValue getTypeValue() {
                return TypeValue.STRING;
            }
        };
    }
}
