package parserTest.node;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import parser.node.impl.literalNodes.TypeValue;
import utils.NodeUtils;

public class BooleanLiteralValueTest {

  @Test
  public void testBooleanLiteral() {
    List.of(false, true)
        .forEach(
            b -> {
              final var booleanLiteralValue = NodeUtils.boolValue(b);

              assertThat(booleanLiteralValue.getValue()).isEqualTo(b);
              assertThat(booleanLiteralValue.getTypeValue()).isEqualTo(TypeValue.BOOLEAN);
              assertThat(booleanLiteralValue.toString()).isEqualTo(Boolean.toString(b));
            });
  }
}
