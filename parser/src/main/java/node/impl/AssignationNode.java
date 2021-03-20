package node.impl;

import node.Node;
import node.interfaces.Calculable;
import node.interfaces.Declarational;
import node.visitor.NodeVisitor;

public class AssignationNode<T> implements Node {

    private final Calculable<T> calculable;
    private final Declarational declarational;

    public AssignationNode(Calculable<T> calculable, Declarational declarational) {
        this.calculable = calculable;
        this.declarational = declarational;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
