package parserTest.node;

import static utils.NodeUtils.*;

import java.util.Set;
import org.junit.Test;
import parser.node.impl.literalNodes.TypeValue;

public class NodeVisitorTest {

  /** This test is only to raise coverage */
  @Test
  public void nodeVisitorTest() {
    final var id = identifierNode("id");
    final var calc = strValueNode("");

    Set.of(
            emptyNode(),
            printNode(calc),
            assignNode(id, calc),
            declNode(id, TypeValue.BOOLEAN),
            id,
            sumNode(calc, calc),
            divisionNode(calc, calc),
            minusNode(calc, calc),
            multiplyNode(calc, calc),
            calc,
            greaterNode(calc, calc),
            lessNode(calc, calc),
            greaterEqualNode(calc, calc),
            lessEqualNode(calc, calc))
        .forEach(n -> n.accept(emptyNodeVisitor()));
  }
}
