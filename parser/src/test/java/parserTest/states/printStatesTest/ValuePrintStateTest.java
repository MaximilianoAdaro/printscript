package parserTest.states.printStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;

public class ValuePrintStateTest {

  @Test
  public void toValuePrintPrintSate_shouldThrowException() {
    String text = "println( 123 ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens)).isInstanceOf(RuntimeException.class);
  }
}
