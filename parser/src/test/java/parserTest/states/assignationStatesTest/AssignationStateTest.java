package parserTest.states.assignationStatesTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import lombok.val;
import org.junit.Test;
import parser.Parser;
import parser.exception.ParserException;

public class AssignationStateTest {

  @Test
  public void fromDeclarationSate_whenTypeString_shouldThrowException() {
    String text = "let x: string = ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens))
        .isInstanceOf(ParserException.class)
        .hasMessage("Unexpected value at line 1 and column 17 -> ;");
  }

  @Test
  public void fromDeclarationSate_whenTypeNumber_shouldThrowException() {
    String text = "let x: number = ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens))
        .isInstanceOf(ParserException.class)
        .hasMessage("Unexpected value at line 1 and column 17 -> ;");
  }

  @Test
  public void fromIdentifierAssignationSate_shouldThrowException() {
    String text = "x = ;";
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens))
        .isInstanceOf(ParserException.class)
        .hasMessage("Unexpected value at line 1 and column 5 -> ;");
  }

  @Test
  public void testShouldFailDueToConstNotAssigned() {
    val text = """
                const x: string;
                """;
    List<Token> tokens = Lexer.lex(text);
    assertThatThrownBy(() -> Parser.parse(tokens))
        .isInstanceOf(ParserException.class)
        .hasMessage("Unexpected value at line 1 and column 16 -> ;");
  }
}
