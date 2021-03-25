package node.impl.literalNodes;

import node.interfaces.LiteralValue;

public class StringLiteralValue implements LiteralValue {

    private final String value;

    public StringLiteralValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public TypeValue getTypeValue() {
        return TypeValue.STRING;
    }
}
