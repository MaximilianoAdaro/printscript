package lexer.state.impls;

import static lexer.utils.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import lexer.model.TokenType;
import org.junit.Test;

public class TextStateTest {

  @Test
  public void newlineShouldReturnEmpty() {
    final var actual = cts(clc("hello", cp(1, 1, 1, 5))).nextValue('\n');
    final var expected = ces(clc("", cp(2, 2, 0, 0)));
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void whitespaceShouldReturnEmpty() {
    getWhitespace()
        .forEach(
            whitespace -> {
              final var actual = cts(clc("hello", cp(1, 1, 1, 5))).nextValue(whitespace);
              final var expected = ces(clc("", cp(1, 1, 6, 6)));

              assertThat(actual).isEqualTo(expected);
            });
  }

  @Test
  public void symbolShouldReturnSymbol() {
    getSymbols()
        .forEach(
            symbol -> {
              final var actual = cts(clc("hello", cp(1, 1, 1, 5))).nextValue(symbol);
              final var expected = csys(clc(symbol.toString(), cp(1, 1, 6, 6)));

              assertThat(actual).isEqualTo(expected);
            });
  }

  @Test
  public void alphaNumericShouldReturnText() {
    getAlphaNumeric()
        .forEach(
            c -> {
              final var actual = cts(clc("hello", cp(1, 1, 1, 5))).nextValue(c);
              final var expected = cts(clc("hello" + c, cp(1, 1, 1, 6)));

              assertThat(actual).isEqualTo(expected);
            });
  }

  @Test
  public void ifNextCharIsAlphaNumericGetTokenShouldReturnEmpty() {
    getAlphaNumeric()
        .forEach(
            c -> {
              final var textState = cts(clc("hello", cp(1, 1, 1, 5)));
              textState.nextValue(c);
              final var actual = textState.getToken();
              assertThat(actual).isEmpty();
            });
  }

  @Test
  public void ifNextCharIsNotAlphaNumericGetTokenShouldReturnEmpty() {
    final var tokens =
        List.of(
            ct("let", TokenType.LET, cp(1, 1, 1, 3)),
            ct("const", TokenType.CONST, cp(1, 1, 1, 5)),
            ct("println", TokenType.PRINT, cp(1, 1, 1, 7)),
            ct("number", TokenType.NUMBER_TYPE, cp(1, 1, 1, 6)),
            ct("string", TokenType.STRING_TYPE, cp(1, 1, 1, 6)),
            ct("var", TokenType.IDENTIFIER, cp(1, 1, 1, 3)));

    getSymbolsNewlineAndWhitespace()
        .forEach(
            c ->
                tokens.forEach(
                    token -> {
                      final var textState = cts(clc(token.getValue(), token.getPosition()));
                      textState.nextValue(c);
                      final var actual = textState.getToken();
                      final var expected = Optional.of(token);
                      assertThat(actual).isNotEmpty().isEqualTo(expected);
                    }));
  }
}
