package interpreter.interpetation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import interpreter.Interpreter;
import interpreter.exception.InterpreterException;
import java.util.ArrayList;
import java.util.List;
import lexer.Lexer;
import org.junit.Test;
import parser.Parser;
import parser.node.Node;

public class InterpreterImplTest {

  @Test
  public void interpreterTest() {
    final var text =
        """
            let x: string = "El resultado es = ";
            let x1: number = 0.1;
            let x2: number = 0.01;
            let x3: number = 102.7 + 123 * x1 * 10 - 15 / x2;
            println(x + x3);
            """;
    final var nodes = getNodes(text);

    final var prints = new ArrayList<String>();
    Interpreter.run(nodes, prints::add);

    assertThat(prints).hasSize(1).containsExactly("El resultado es = -1274.3");
  }

  @Test
  public void testInvalidType() {
    final var text = """
               let x: string = 4;
                """;

    testException(text, "number 4.0 can't be assigned to variable x of type string on line 0");
  }

  @Test
  public void testVar() {
    final var text = """
               x = 4;
                """;

    testException(text, "Variable with name x doesn't exist on line 0");
  }

  @Test
  public void testNotInitVar() {
    final var text =
        """
               let y: number;
               let x: number = y;
                """;

    testException(text, "Variable with name y is not initialized on line 0");
  }

  @Test
  public void invalidOp() {
    final var text = """
               let y: number = 8 * "hello";
                """;

    testException(text, "Invalid operation with number 8.0 and string hello one line 0");
  }

  private void testException(String text, String s) {
    final var nodes = getNodes(text);

    assertThatThrownBy(() -> Interpreter.run(nodes, __ -> {}))
        .isInstanceOf(InterpreterException.class)
        .hasMessage(s);
  }

  private List<Node> getNodes(String text) {
    final var tokens = Lexer.lex(text);
    return Parser.parse(tokens);
  }
}
