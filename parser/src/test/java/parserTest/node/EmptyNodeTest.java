package parserTest.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.NodeUtils.*;

import lexer.model.Position;
import org.junit.Test;
import parser.node.impl.EmptyNode;

public class EmptyNodeTest {

  @Test
  public void emptyNodeTest() {
    final var emptyNode = new EmptyNode(Position.empty());

    assertThat(emptyNode.calculate(emptyNodeVisitor())).isEqualTo(strValue(""));
    assertThatThrownBy(() -> emptyNode.resolveTree(null, null))
        .isInstanceOf(RuntimeException.class);
  }
}
