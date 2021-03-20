package node.impl.literalNodes;

import node.interfaces.LiteralValue;

public class NumberLiteralValue implements LiteralValue<Double> {

    private final double value;

    public NumberLiteralValue(double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public TypeValue getTypeValue() {
        return TypeValue.NUMBER;
    }
}
