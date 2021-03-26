package parser.node.impl.literalNodes;

import lombok.Data;
import parser.node.interfaces.LiteralValue;

@Data
public class NumberLiteralValue implements LiteralValue {

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