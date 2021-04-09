package parserTest.states.assignationStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;

public class IdentifierAssignationStateTest {

  @Test
  public void toIdentifierAssignationState_shouldThrowException() {
    String text = "x;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens)).isInstanceOf(RuntimeException.class);
  }
}
