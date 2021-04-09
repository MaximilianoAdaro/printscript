package parserTest.states.assignationStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;

public class AssignationStateTest {

  @Test
  public void fromDeclarationSate_whenTypeString_shouldThrowException() {
    String text = "let x: string = ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void fromDeclarationSate_whenTypeNumber_shouldThrowException() {
    String text = "let x: number = ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void fromIdentifierAssignationSate_shouldThrowException() {
    String text = "x = ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens)).isInstanceOf(RuntimeException.class);
  }
}
