package node;

public class IdentifierNode<T> implements Calculable<T>, Nameable {

    private final String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    @Override
    public void accept() {

    }

    @Override
    public T calculate() {
        return null;
    }
}
