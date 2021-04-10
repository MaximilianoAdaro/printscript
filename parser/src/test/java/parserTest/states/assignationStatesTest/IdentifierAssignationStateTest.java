package parserTest.states.assignationStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;
import parser.exception.ParserException;

public class IdentifierAssignationStateTest {

  @Test
  public void toIdentifierAssignationState_shouldThrowException() {
    String text = "xx;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens))
        .isInstanceOf(ParserException.class)
        .hasMessage("Unexpected value at line 1 between columns ( 1, 2 ) -> xx");
  }
}
