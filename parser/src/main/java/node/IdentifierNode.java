package node;

import node.interfaces.Calculable;
import node.interfaces.Declarational;

public class IdentifierNode<T> implements Calculable<T>, Declarational {

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
