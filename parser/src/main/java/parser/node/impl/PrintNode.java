package parser.node.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import parser.node.Node;
import parser.node.interfaces.Calculable;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
@AllArgsConstructor
public class PrintNode implements Node {

    private final Calculable calculable;

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
