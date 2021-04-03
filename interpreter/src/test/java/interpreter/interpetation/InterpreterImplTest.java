package interpreter.interpetation;

import lexer.LexerImpl;
import org.junit.Test;
import parser.ParserImpl;

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
    final var tokens = LexerImpl.lex(text);
    final var nodes = ParserImpl.parse(tokens);
    InterpreterImpl.run(nodes);
  }
}
