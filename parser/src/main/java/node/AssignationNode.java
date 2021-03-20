package node;

import node.interfaces.Calculable;
import node.interfaces.Declarational;
import node.interfaces.Node;

public class AssignationNode<T> implements Node {

    private final Calculable<T> rightNode;
    private final Declarational declarational;

    public AssignationNode(Calculable<T> rightNode, Declarational declarational) {
        this.rightNode = rightNode;
        this.declarational = declarational;
    }

    @Override
    public void accept() {

    }
}
