package parserTest.states.printStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;
import parser.exception.ParserException;

public class IdentifiedPrintStateTest {

  @Test
  public void toIdentifiedPrintSate_shouldThrowException() {
    String text = "println( x ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens))
        .isInstanceOf(ParserException.class)
        .hasMessage("Unexpected value at line 1 and column 12 -> ;");
  }
}
