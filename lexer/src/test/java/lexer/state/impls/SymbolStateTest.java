package lexer.state.impls;

import static lexer.model.TokenType.*;
import static lexer.utils.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Map;
import java.util.Optional;
import org.junit.Test;

public class SymbolStateTest {

  @Test
  public void newlineShouldReturnEmpty() {
    getSymbols()
        .forEach(
            c -> {
              final var actual = csys(clc(c.toString(), cp(1, 1, 1, 1))).nextValue('\n');
              final var expected = ces(clc("", cp(2, 2, 0, 0)));

              assertThat(actual).isEqualTo(expected);
            });
  }

  @Test
  public void whitespaceShouldReturnEmpty() {
    getSymbols()
        .forEach(
            c ->
                getWhitespace()
                    .forEach(
                        whitespace -> {
                          final var actual =
                              csys(clc(c.toString(), cp(1, 1, 1, 1))).nextValue(whitespace);
                          final var expected = ces(clc("", cp(1, 1, 2, 2)));

                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void numberShouldReturnNumber() {
    getSymbols()
        .forEach(
            c ->
                getNumbers()
                    .forEach(
                        number -> {
                          final var actual =
                              csys(clc(c.toString(), cp(1, 1, 1, 1))).nextValue(number);
                          final var expected = cns(clc(number.toString(), cp(1, 1, 2, 2)));

                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void stringSymbolShouldReturnString() {
    getSymbols()
        .forEach(
            c ->
                getStringSymbols()
                    .forEach(
                        stringSymbol -> {
                          final var actual =
                              csys(clc(c.toString(), cp(1, 1, 1, 1))).nextValue(stringSymbol);
                          final var expected = css(clc("", cp(1, 1, 2, 2)), stringSymbol, false);

                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void ifNextCharIsSymbolGetTokenShouldReturnEmpty() {
    final var pos = cp(1, 1, 1, 1);
    final var textWithToken =
        Map.ofEntries(
            entry(";", ct(";", SEMICOLON, pos)),
            entry(":", ct(":", COLON, pos)),
            entry("=", ct("=", ASSIGNATION, pos)),
            entry("(", ct("(", LEFT_PAREN, pos)),
            entry(")", ct(")", RIGHT_PAREN, pos)),
            entry("-", ct("-", MINUS, pos)),
            entry("+", ct("+", PLUS, pos)),
            entry("*", ct("*", MULTIPLY, pos)),
            entry("/", ct("/", DIVIDE, pos)),
            entry(">", ct(">", GREATER, pos)),
            entry(">=", ct(">=", GREATER_EQUAL, cp(1, 1, 1, 2))),
            entry("<", ct("<", LESS, pos)),
            entry("<=", ct("<=", LESS_EQUAL, cp(1, 1, 1, 2))));

    textWithToken.forEach(
        (text, token) -> {
          final var state = csys(clc(text, token.getPosition()));
          state.nextValue('*');
          final var actual = state.getToken();
          assertThat(actual).isEmpty();
        });
  }

  @Test
  public void getTokenShouldReturnToken() {
    final var pos = cp(1, 1, 1, 1);
    final var textWithToken =
        Map.ofEntries(
            entry(";", ct(";", SEMICOLON, pos)),
            entry(":", ct(":", COLON, pos)),
            entry("=", ct("=", ASSIGNATION, pos)),
            entry("(", ct("(", LEFT_PAREN, pos)),
            entry(")", ct(")", RIGHT_PAREN, pos)),
            entry("-", ct("-", MINUS, pos)),
            entry("+", ct("+", PLUS, pos)),
            entry("*", ct("*", MULTIPLY, pos)),
            entry("/", ct("/", DIVIDE, pos)),
            entry(">", ct(">", GREATER, pos)),
            entry(">=", ct(">=", GREATER_EQUAL, cp(1, 1, 1, 2))),
            entry("<", ct("<", LESS, pos)),
            entry("<=", ct("<=", LESS_EQUAL, cp(1, 1, 1, 2))));

    textWithToken.forEach(
        (text, token) -> {
          final var state = csys(clc(text, token.getPosition()));
          state.nextValue(' ');
          final var actual = state.getToken();
          final var expected = Optional.of(token);
          assertThat(actual).isNotEmpty().isEqualTo(expected);
        });
  }
}
