package node.literalNode;

import node.interfaces.Calculable;
import node.interfaces.LiteralValue;

public class LiteralNode<T> implements Calculable<T> {

    private final LiteralValue<T> literalValue;

    public LiteralNode(LiteralValue<T> literalValue) {
        this.literalValue = literalValue;
    }

    @Override
    public void accept() {

    }

    @Override
    public T calculate() {
        return null;
    }
}
