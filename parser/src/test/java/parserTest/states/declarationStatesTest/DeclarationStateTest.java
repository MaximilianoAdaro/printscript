package parserTest.states.declarationStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;

public class DeclarationStateTest {

  @Test
  public void toDeclarationSate_shouldThrowException() {
    String text = "let;";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }
}
