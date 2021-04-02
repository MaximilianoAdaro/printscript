package parserTest.states.printStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;

public class ValuePrintStateTest {

  @Test
  public void toValuePrintPrintSate_shouldThrowException() {
    String text = "println( 123 ;";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }
}
