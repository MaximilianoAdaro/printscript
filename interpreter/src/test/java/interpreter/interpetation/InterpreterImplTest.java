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
    final var expected = "El resultado es = -1274.3";

    shouldPrintExpected(text, expected);
  }

  private void shouldPrintExpected(String text, String expected) {
    final var nodes = getNodes(text);

    final var prints = new ArrayList<String>();
    Interpreter.run(nodes, prints::add);

    assertThat(prints).hasSize(1).containsExactly(expected);
  }

  @Test
  public void testBoolGreater() {
    final var text =
        """
                const x: string = "El resultado es = ";
                const bool: boolean = 3 * 5 > 4 - 3;
                println(x + bool);
                """;
    final var expected = "El resultado es = true";

    shouldPrintExpected(text, expected);
  }

  @Test
  public void testBoolGreaterEqual() {
    final var text =
        """
                const x: string = "El resultado es = ";
                const bool: boolean = 3 * 5 >= 4 - 3;
                println(x + bool);
                """;
    final var expected = "El resultado es = true";

    shouldPrint(text, expected);
  }

  @Test
  public void testBoolLess() {
    final var text =
        """
                const x: string = "El resultado es = ";
                const bool: boolean = 3 * 5 < 4 - 3;
                println(x + bool);
                """;
    final var expected = "El resultado es = false";

    shouldPrint(text, expected);
  }

  @Test
  public void testBoolLessEqual() {
    final var text =
        """
                const x: string = "El resultado es = ";
                const bool: boolean = 2 - 1 <= 4 - 3;
                println(x + bool);
                """;
    final var expected = "El resultado es = true";

    shouldPrint(text, expected);
  }

  private void shouldPrint(String text, String expected) {
    shouldPrintExpected(text, expected);
  }

  @Test
  public void testInvalidType() {
    final var text = """
               let x: string = 4;
                """;

    testException(text, "number 4.0 can't be assigned to variable x of type string on line 1");
  }

  @Test
  public void testVar() {
    final var text = """
               x = 4;
                """;

    testException(text, "Variable with name x doesn't exist on line 1");
  }

  @Test
  public void testNotInitVar() {
    final var text =
        """
               let y: number;
               let x: number = y;
                """;

    testException(text, "Variable with name y is not initialized on line 2");
  }

  @Test
  public void invalidOp() {
    final var text = """
               let y: number = 8 * "hello";
                """;

    testException(text, "Invalid operation with number 8.0 and string hello on line 1");
  }

  @Test
  public void invalidConstOp() {
    final var text =
        """
               const y: number = 8;
               y = 10;
                """;

    testException(text, "Cannot reassign constant y with value 10.0 on line 2");
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
