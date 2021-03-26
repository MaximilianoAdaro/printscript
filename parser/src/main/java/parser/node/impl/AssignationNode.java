package parser.node.impl;

import parser.node.Node;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;
import parser.node.visitor.NodeVisitor;

public class AssignationNode implements Node {

    private final Calculable calculable;
    private final Declarational declarational;

    public AssignationNode(Calculable calculable, Declarational declarational) {
        this.calculable = calculable;
        this.declarational = declarational;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
