package parserTest.states.declarationStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;
import parser.exception.ParserException;

public class DeclarationStateTest {

  @Test
  public void toDeclarationSate_shouldThrowException() {
    String text = "let;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens))
        .isInstanceOf(ParserException.class)
        .hasMessage("Unexpected value at line 1 and column 4 -> ;");
  }
}
