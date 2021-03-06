package lexer;

import static java.util.Map.entry;
import static lexer.model.TokenType.*;
import static lexer.utils.TestUtils.cp;
import static lexer.utils.TestUtils.ct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import fileReader.FileReaderPS;
import java.util.List;
import java.util.Map;
import lexer.exception.LexerException;
import lexer.model.Token;
import org.junit.Test;

public class LexerImplTest {

  private List<Token> lex(String text) {
    return Lexer.lex(text);
  }

  private void testWithExpected(String text, List<Token> expected) {
    final var tokens = lex(text);

    assertThat(tokens).hasSize(expected.size()).isEqualTo(expected);
  }

  @Test
  public void testIndividualTokens() {
    Map<String, Token> expectedTokens =
        Map.ofEntries(
            entry(";", ct(";", SEMICOLON, cp(1, 1, 1, 1))),
            entry(":", ct(":", COLON, cp(1, 1, 1, 1))),
            entry("=", ct("=", ASSIGNATION, cp(1, 1, 1, 1))),
            entry("(", ct("(", LEFT_PAREN, cp(1, 1, 1, 1))),
            entry(")", ct(")", RIGHT_PAREN, cp(1, 1, 1, 1))),
            entry("{", ct("{", LEFT_CURLY_BRACES, cp(1, 1, 1, 1))),
            entry("}", ct("}", RIGHT_CURLY_BRACES, cp(1, 1, 1, 1))),
            entry("-", ct("-", MINUS, cp(1, 1, 1, 1))),
            entry("+", ct("+", PLUS, cp(1, 1, 1, 1))),
            entry("*", ct("*", MULTIPLY, cp(1, 1, 1, 1))),
            entry("/", ct("/", DIVIDE, cp(1, 1, 1, 1))),
            entry(">=", ct(">=", GREATER_EQUAL, cp(1, 1, 1, 2))),
            entry(">", ct(">", GREATER, cp(1, 1, 1, 1))),
            entry("<=", ct("<=", LESS_EQUAL, cp(1, 1, 1, 2))),
            entry("<", ct("<", LESS, cp(1, 1, 1, 1))),
            entry("identifier", ct("identifier", IDENTIFIER, cp(1, 1, 1, 10))),
            entry("variable", ct("variable", IDENTIFIER, cp(1, 1, 1, 8))),
            entry("'This is a string'", ct("This is a string", STRING, cp(1, 1, 1, 17))),
            entry("\"This is a string\"", ct("This is a string", STRING, cp(1, 1, 1, 17))),
            entry("1", ct("1", NUMBER, cp(1, 1, 1, 1))),
            entry("56348563", ct("56348563", NUMBER, cp(1, 1, 1, 8))),
            entry("563.48563", ct("563.48563", NUMBER, cp(1, 1, 1, 9))),
            entry("println", ct("println", PRINT, cp(1, 1, 1, 7))),
            entry("let", ct("let", LET, cp(1, 1, 1, 3))),
            entry("const", ct("const", CONST, cp(1, 1, 1, 5))),
            entry("true", ct("true", BOOLEAN, cp(1, 1, 1, 4))),
            entry("false", ct("false", BOOLEAN, cp(1, 1, 1, 5))),
            entry("number", ct("number", NUMBER_TYPE, cp(1, 1, 1, 6))),
            entry("string", ct("string", STRING_TYPE, cp(1, 1, 1, 6))),
            entry("boolean", ct("boolean", BOOLEAN_TYPE, cp(1, 1, 1, 7))),
            entry("if", ct("if", IF, cp(1, 1, 1, 2))),
            entry("else", ct("else", ELSE, cp(1, 1, 1, 4))));

    expectedTokens.forEach((value, token) -> testWithExpected(value, List.of(token)));
  }

  @Test
  public void testGroupedTokens() {
    final var textWithExpected =
        Map.ofEntries(
            entry(
                "let x = 2;",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("x", IDENTIFIER, cp(1, 1, 5, 5)),
                    ct("=", ASSIGNATION, cp(1, 1, 7, 7)),
                    ct("2", NUMBER, cp(1, 1, 9, 9)),
                    ct(";", SEMICOLON, cp(1, 1, 10, 10)))),
            entry(
                "let x=2;",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("x", IDENTIFIER, cp(1, 1, 5, 5)),
                    ct("=", ASSIGNATION, cp(1, 1, 6, 6)),
                    ct("2", NUMBER, cp(1, 1, 7, 7)),
                    ct(";", SEMICOLON, cp(1, 1, 8, 8)))),
            entry(
                "let x =2;",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("x", IDENTIFIER, cp(1, 1, 5, 5)),
                    ct("=", ASSIGNATION, cp(1, 1, 7, 7)),
                    ct("2", NUMBER, cp(1, 1, 8, 8)),
                    ct(";", SEMICOLON, cp(1, 1, 9, 9)))),
            entry(
                "let x= 2;",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("x", IDENTIFIER, cp(1, 1, 5, 5)),
                    ct("=", ASSIGNATION, cp(1, 1, 6, 6)),
                    ct("2", NUMBER, cp(1, 1, 8, 8)),
                    ct(";", SEMICOLON, cp(1, 1, 9, 9)))),
            entry(
                "let x= 2 ;",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("x", IDENTIFIER, cp(1, 1, 5, 5)),
                    ct("=", ASSIGNATION, cp(1, 1, 6, 6)),
                    ct("2", NUMBER, cp(1, 1, 8, 8)),
                    ct(";", SEMICOLON, cp(1, 1, 10, 10)))),
            entry(
                "let     x           =         2      ;",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("x", IDENTIFIER, cp(1, 1, 9, 9)),
                    ct("=", ASSIGNATION, cp(1, 1, 21, 21)),
                    ct("2", NUMBER, cp(1, 1, 31, 31)),
                    ct(";", SEMICOLON, cp(1, 1, 38, 38)))),
            entry(
                "  let x\t=2;",
                List.of(
                    ct("let", LET, cp(1, 1, 3, 5)),
                    ct("x", IDENTIFIER, cp(1, 1, 7, 7)),
                    ct("=", ASSIGNATION, cp(1, 1, 9, 9)),
                    ct("2", NUMBER, cp(1, 1, 10, 10)),
                    ct(";", SEMICOLON, cp(1, 1, 11, 11)))),
            entry(
                "let var\n" + "=2;",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("var", IDENTIFIER, cp(1, 1, 5, 7)),
                    ct("=", ASSIGNATION, cp(2, 2, 1, 1)),
                    ct("2", NUMBER, cp(2, 2, 2, 2)),
                    ct(";", SEMICOLON, cp(2, 2, 3, 3)))),
            entry(
                """
                                let var
                                =2
                                ;""",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("var", IDENTIFIER, cp(1, 1, 5, 7)),
                    ct("=", ASSIGNATION, cp(2, 2, 1, 1)),
                    ct("2", NUMBER, cp(2, 2, 2, 2)),
                    ct(";", SEMICOLON, cp(3, 3, 1, 1)))),
            entry(
                """
                                let var
                                =2

                                ;""",
                List.of(
                    ct("let", LET, cp(1, 1, 1, 3)),
                    ct("var", IDENTIFIER, cp(1, 1, 5, 7)),
                    ct("=", ASSIGNATION, cp(2, 2, 1, 1)),
                    ct("2", NUMBER, cp(2, 2, 2, 2)),
                    ct(";", SEMICOLON, cp(4, 4, 1, 1)))));

    textWithExpected.forEach(this::testWithExpected);
  }

  @Test
  public void testMultipleStatements() {
    final var text =
        """
                let var: number = 100;
                var = var + 10;
                let hello: string = 'hello';
                let result: string = hello + var;
                println(result);""";

    final var expected =
        List.of(
            ct("let", LET, cp(1, 1, 1, 3)),
            ct("var", IDENTIFIER, cp(1, 1, 5, 7)),
            ct(":", COLON, cp(1, 1, 8, 8)),
            ct("number", NUMBER_TYPE, cp(1, 1, 10, 15)),
            ct("=", ASSIGNATION, cp(1, 1, 17, 17)),
            ct("100", NUMBER, cp(1, 1, 19, 21)),
            ct(";", SEMICOLON, cp(1, 1, 22, 22)),
            ct("var", IDENTIFIER, cp(2, 2, 1, 3)),
            ct("=", ASSIGNATION, cp(2, 2, 5, 5)),
            ct("var", IDENTIFIER, cp(2, 2, 7, 9)),
            ct("+", PLUS, cp(2, 2, 11, 11)),
            ct("10", NUMBER, cp(2, 2, 13, 14)),
            ct(";", SEMICOLON, cp(2, 2, 15, 15)),
            ct("let", LET, cp(3, 3, 1, 3)),
            ct("hello", IDENTIFIER, cp(3, 3, 5, 9)),
            ct(":", COLON, cp(3, 3, 10, 10)),
            ct("string", STRING_TYPE, cp(3, 3, 12, 17)),
            ct("=", ASSIGNATION, cp(3, 3, 19, 19)),
            ct("hello", STRING, cp(3, 3, 21, 26)),
            ct(";", SEMICOLON, cp(3, 3, 27, 27)),
            ct("let", LET, cp(4, 4, 1, 3)),
            ct("result", IDENTIFIER, cp(4, 4, 5, 10)),
            ct(":", COLON, cp(4, 4, 11, 11)),
            ct("string", STRING_TYPE, cp(4, 4, 13, 18)),
            ct("=", ASSIGNATION, cp(4, 4, 20, 20)),
            ct("hello", IDENTIFIER, cp(4, 4, 22, 26)),
            ct("+", PLUS, cp(4, 4, 28, 28)),
            ct("var", IDENTIFIER, cp(4, 4, 30, 32)),
            ct(";", SEMICOLON, cp(4, 4, 33, 33)),
            ct("println", PRINT, cp(5, 5, 1, 7)),
            ct("(", LEFT_PAREN, cp(5, 5, 8, 8)),
            ct("result", IDENTIFIER, cp(5, 5, 9, 14)),
            ct(")", RIGHT_PAREN, cp(5, 5, 15, 15)),
            ct(";", SEMICOLON, cp(5, 5, 16, 16)));

    testWithExpected(text, expected);
  }

  @Test
  public void testDecimal() {
    final var s = "22342.23423";
    final var expected = List.of(ct("22342.23423", NUMBER, cp(1, 1, 1, 11)));
    testWithExpected(s, expected);
  }

  @Test
  public void testConstKeyword() {
    final var s = "const x = 2;";
    final var expected =
        List.of(
            ct("const", CONST, cp(1, 1, 1, 5)),
            ct("x", IDENTIFIER, cp(1, 1, 7, 7)),
            ct("=", ASSIGNATION, cp(1, 1, 9, 9)),
            ct("2", NUMBER, cp(1, 1, 11, 11)),
            ct(";", SEMICOLON, cp(1, 1, 12, 12)));
    testWithExpected(s, expected);
  }

  @Test
  public void testBoolean() {
    final var textWithExpected =
        Map.ofEntries(
            entry(
                "const x: boolean = true;",
                List.of(
                    ct("const", CONST, cp(1, 1, 1, 5)),
                    ct("x", IDENTIFIER, cp(1, 1, 7, 7)),
                    ct(":", COLON, cp(1, 1, 8, 8)),
                    ct("boolean", BOOLEAN_TYPE, cp(1, 1, 10, 16)),
                    ct("=", ASSIGNATION, cp(1, 1, 18, 18)),
                    ct("true", BOOLEAN, cp(1, 1, 20, 23)),
                    ct(";", SEMICOLON, cp(1, 1, 24, 24)))),
            entry(
                "const x: boolean = false;",
                List.of(
                    ct("const", CONST, cp(1, 1, 1, 5)),
                    ct("x", IDENTIFIER, cp(1, 1, 7, 7)),
                    ct(":", COLON, cp(1, 1, 8, 8)),
                    ct("boolean", BOOLEAN_TYPE, cp(1, 1, 10, 16)),
                    ct("=", ASSIGNATION, cp(1, 1, 18, 18)),
                    ct("false", BOOLEAN, cp(1, 1, 20, 24)),
                    ct(";", SEMICOLON, cp(1, 1, 25, 25)))));

    textWithExpected.forEach(this::testWithExpected);
  }

  @Test
  public void testNotDecimal() {
    final var s = "22342.234.23";
    assertThatThrownBy(() -> lex(s))
        .isInstanceOf(LexerException.class)
        .hasMessage("Unexpected text at line: 1 between columns: ( 1, 9 ) -> 22342.234.");
  }

  @Test
  public void testString() {
    final var s = """
                'hello
                world'""";

    assertThatThrownBy(() -> lex(s))
        .isInstanceOf(LexerException.class)
        .hasMessage("Unclosed string at line: 1 between columns: ( 1, 6 ) -> hello");
  }

  @Test
  public void testIfElse() {
    final var text =
        """
            if (true) {
                println();
            } else {
                println();
            }""";

    final var expected = FileReaderPS.readFile("./src/test/resources/ifelsetest/ifelse.txt");

    final var actual = lex(text).toString();

    assertThat(actual).isEqualTo(expected);
  }
}
