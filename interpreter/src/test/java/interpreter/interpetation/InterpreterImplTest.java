package interpreter.interpetation;

import lexer.LexerImpl;
import org.junit.Test;
import parser.ParserImpl;

public class InterpreterImplTest {

  @Test
  public void xx() {
    final var text = "let x: number = 5;";
    final var tokens = LexerImpl.lex(text);
    final var nodes = ParserImpl.parse(tokens);

    InterpreterImpl.run(nodes);
  }
}
