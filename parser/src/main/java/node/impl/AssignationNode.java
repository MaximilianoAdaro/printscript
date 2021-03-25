package node.impl;

import node.Node;
import node.interfaces.Calculable;
import node.interfaces.Declarational;
import node.visitor.NodeVisitor;

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
