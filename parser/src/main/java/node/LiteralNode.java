package node;

public class LiteralNode implements Node {

    private final LiteralValue literalValue;

    public LiteralNode(LiteralValue literalValue) {
        this.literalValue = literalValue;
    }

    @Override
    public void accept() {

    }
}
