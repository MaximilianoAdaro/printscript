package parserTest.states.printStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;

public class PrintStateTest {

  @Test
  public void toPrintSate_shouldThrowException() {
    String text = "println;";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }
}
