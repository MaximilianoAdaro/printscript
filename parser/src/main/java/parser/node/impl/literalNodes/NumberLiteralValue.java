package parser.node.impl.literalNodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import parser.node.interfaces.LiteralValue;

@Data
@Builder
@AllArgsConstructor
public class NumberLiteralValue implements LiteralValue {

  private final double value;

  @Override
  public Double getValue() {
    return value;
  }

  @Override
  public TypeValue getTypeValue() {
    return TypeValue.NUMBER;
  }

  @Override
  public String toString() {
    if (value == Math.floor(value) && !Double.isInfinite(value))
      return Integer.toString((int) value);
    return Double.toString(value);
  }
}
