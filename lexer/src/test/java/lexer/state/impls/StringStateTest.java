package lexer.state.impls;

import static lexer.utils.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;
import lexer.exception.LexerException;
import lexer.model.TokenType;
import org.junit.Test;

public class StringStateTest {

  @Test
  public void newlineToNotDoneStringShouldNotWork() {
    getStringSymbols()
        .forEach(
            startSymbol -> {
              final var state = css(clc("'hello", cp(1, 1, 1, 6)), startSymbol, false);
              assertThatThrownBy(() -> state.nextValue('\n'))
                  .isInstanceOf(LexerException.class)
                  .hasMessage("Unclosed string at line: 1 between columns: ( 1, 6 ) -> 'hello");
            });
  }

  @Test
  public void anythingExceptNewlineToNotDoneStringShouldReturnString() {
    getStringSymbols()
        .forEach(
            startSymbol ->
                getAllAsciiCharacters()
                    .forEach(
                        c -> {
                          if (c == '\n') return;

                          final var actual =
                              css(clc("hello", cp(1, 1, 2, 6)), startSymbol, false).nextValue(c);

                          final var expected =
                              startSymbol == c
                                  ? css(clc("hello", cp(1, 1, 2, 6)), startSymbol, true)
                                  : css(clc("hello" + c, cp(1, 1, 2, 7)), startSymbol, false);

                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void newlineToDoneStringShouldReturnEmpty() {
    getStringSymbols()
        .forEach(
            startSymbol -> {
              final var actual =
                  css(clc(startSymbol + "hello" + startSymbol, cp(1, 1, 1, 7)), startSymbol, true)
                      .nextValue('\n');
              final var expected = ces(clc("", cp(2, 2, 0, 0)));
              assertThat(actual).isEqualTo(expected);
            });
  }

  @Test
  public void whitespaceToDoneStringShouldReturnEmpty() {
    getStringSymbols()
        .forEach(
            startSymbol ->
                getWhitespace()
                    .forEach(
                        c -> {
                          final var actual =
                              css(
                                      clc(startSymbol + "hello" + startSymbol, cp(1, 1, 1, 7)),
                                      startSymbol,
                                      true)
                                  .nextValue(c);
                          final var expected = ces(clc("", cp(1, 1, 8, 8)));
                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void symbolToDoneStringShouldReturnSymbol() {
    getStringSymbols()
        .forEach(
            startSymbol ->
                getSymbols()
                    .forEach(
                        c -> {
                          final var actual =
                              css(
                                      clc(startSymbol + "hello" + startSymbol, cp(1, 1, 1, 7)),
                                      startSymbol,
                                      true)
                                  .nextValue(c);
                          final var expected = csys(clc(c.toString(), cp(1, 1, 8, 8)));
                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void numberToDoneStringShouldReturnNumber() {
    getStringSymbols()
        .forEach(
            startSymbol ->
                getNumbers()
                    .forEach(
                        c -> {
                          final var actual =
                              css(
                                      clc(startSymbol + "hello" + startSymbol, cp(1, 1, 1, 7)),
                                      startSymbol,
                                      true)
                                  .nextValue(c);
                          final var expected = cns(clc(c.toString(), cp(1, 1, 8, 8)));
                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void letterToDoneStringShouldReturnText() {
    getStringSymbols()
        .forEach(
            startSymbol ->
                getAllLetters()
                    .forEach(
                        c -> {
                          final var actual =
                              css(
                                      clc(startSymbol + "hello" + startSymbol, cp(1, 1, 1, 7)),
                                      startSymbol,
                                      true)
                                  .nextValue(c);
                          final var expected = cts(clc(c.toString(), cp(1, 1, 8, 8)));
                          assertThat(actual).isEqualTo(expected);
                        }));
  }

  @Test
  public void ifStringIsNotDoneGetTokenShouldReturnEmpty() {
    getStringSymbols()
        .forEach(
            s -> {
              final var actual = css(clc(s + "hello", cp(1, 1, 1, 6)), s, false).getToken();

              final var expected = Optional.empty();
              assertThat(actual).isEqualTo(expected);
            });
  }

  @Test
  public void ifStringIsDoneGetTokenShouldReturnToken() {
    getStringSymbols()
        .forEach(
            s -> {
              final var value = s + "hello" + s;
              final var pos = cp(1, 1, 1, 7);
              final var actual = css(clc(value, pos), s, true).getToken();

              final var expected = Optional.of(ct(value, TokenType.STRING, pos));
              assertThat(actual).isNotEmpty().isEqualTo(expected);
            });
  }
}
