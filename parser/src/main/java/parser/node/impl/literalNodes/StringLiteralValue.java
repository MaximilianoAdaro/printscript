package parser.node.impl.literalNodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import parser.node.interfaces.LiteralValue;

@Data
@Builder
@AllArgsConstructor
public class StringLiteralValue implements LiteralValue {

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public TypeValue getTypeValue() {
        return TypeValue.STRING;
    }
}
