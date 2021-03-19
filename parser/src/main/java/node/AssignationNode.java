package node;

public class AssignationNode<T> implements Node {

    private final Calculable<T> rightNode;
    private final Nameable nameable;

    public AssignationNode(Calculable<T> rightNode, Nameable nameable) {
        this.rightNode = rightNode;
        this.nameable = nameable;
    }

    @Override
    public void accept() {

    }
}
