package parser.node.impl;

import lombok.Data;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@Data
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
