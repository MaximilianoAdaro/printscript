package node;

public class IdentifierNode implements Node {

    private final String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    @Override
    public void accept() {

    }
}
