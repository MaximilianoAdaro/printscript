package parser.node.impl.literalNodes;

import lombok.Data;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@Data
public class LiteralNode implements Calculable {

    private final LiteralValue literalValue;

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public LiteralValue calculate() {
        return literalValue;
    }
}
