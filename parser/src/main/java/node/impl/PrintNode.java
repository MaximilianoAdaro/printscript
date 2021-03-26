package node.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import node.Node;
import node.interfaces.Calculable;
import node.visitor.NodeVisitor;

@Data
@AllArgsConstructor
public class PrintNode implements Node {

    private final Calculable calculable;

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
