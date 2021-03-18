package node;

public abstract class TwoOperandNode implements Node {

    private final Node rightNode;
    private final Node leftNode;

    protected TwoOperandNode(Node rightNode, Node leftNode) {
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    @Override
    public void accept() {

    }
}
