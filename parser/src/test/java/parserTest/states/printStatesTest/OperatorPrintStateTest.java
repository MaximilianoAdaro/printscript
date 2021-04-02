package parserTest.states.printStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;

public class OperatorPrintStateTest {

  @Test
  public void toOperatorPrintSate_whenComingFromIdent_shouldThrowException() {
    String text = "println( y - ;";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void toOperatorPrintSate_whenComingFromValue_shouldThrowException() {
    String text = "println( 123 - ;";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void toOperatorPrintSate_whenComingFromSeveralOperators_shouldThrowException() {
    String text = "println( 123 - 23 + s * w ;";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }
}
