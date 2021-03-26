package parser.node.impl;

import lombok.Data;
import parser.node.Node;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;
import parser.node.visitor.NodeVisitor;

@Data
public class AssignationNode implements Node {

    private final Calculable calculable;
    private final Declarational declarational;

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
