package node.impl;

import node.Node;
import node.visitor.NodeVisitor;

public class PrintNode implements Node {

    private final Node node;

    public PrintNode(Node node) {
        this.node = node;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
