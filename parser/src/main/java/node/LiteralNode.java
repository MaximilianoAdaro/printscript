package node;

public class LiteralNode<T> implements Calculable<T> {

    private final LiteralValue literalValue;

    public LiteralNode(LiteralValue literalValue) {
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
