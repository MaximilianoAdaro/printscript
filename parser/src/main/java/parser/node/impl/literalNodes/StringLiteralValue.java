package parser.node.impl.literalNodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import parser.node.interfaces.LiteralValue;

@Data
@AllArgsConstructor
public class StringLiteralValue implements LiteralValue {

    private final String value;

//    @Override
//    public String getValue() {
//        return value;
//    }

    @Override
    public TypeValue getTypeValue() {
        return TypeValue.STRING;
    }
}
