package node;

import node.interfaces.Node;

public class PrintNode implements Node {

    private final Node node;

    public PrintNode(Node node) {
        this.node = node;
    }

    @Override
    public void accept() {

    }
}
