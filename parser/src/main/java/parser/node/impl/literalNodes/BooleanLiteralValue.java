package parser.node.impl.literalNodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import parser.node.interfaces.LiteralValue;

@Data
@Builder
@AllArgsConstructor
public class BooleanLiteralValue implements LiteralValue {

  private final boolean value;

  @Override
  public Object getValue() {
    return value;
  }

  @Override
  public TypeValue getTypeValue() {
    return TypeValue.BOOLEAN;
  }

  @Override
  public String toString() {
    return Boolean.toString(value);
  }
}
