package lexer.state.impls;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static lexer.model.TokenType.*;
import static lexer.utils.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SymbolStateTest {

    @Test
    public void newlineShouldReturnEmpty() {
        getSymbols()
                .forEach(c -> {
                    final var actual = csys(clc(c.toString(), cp(1, 1, 1, 1)))
                            .nextValue('\n');
                    final var expected = ces(clc("", cp(2, 2, 0, 0)));

                    assertThat(actual).isEqualTo(expected);
                });
    }


    @Test
    public void whitespaceShouldReturnEmpty() {
        getSymbols().forEach(c ->
                getWhitespace()
                        .forEach(whitespace -> {
                            final var actual = csys(clc(c.toString(), cp(1, 1, 1, 1)))
                                    .nextValue(whitespace);
                            final var expected = ces(clc("", cp(1, 1, 2, 2)));

                            assertThat(actual).isEqualTo(expected);

                        }));
    }


    @Test
    public void numberShouldReturnNumber() {
        getSymbols().forEach(c ->
                getNumbers()
                        .forEach(number -> {
                            final var actual = csys(
                                    clc(c.toString(), cp(1, 1, 1, 1))
                            ).nextValue(number);
                            final var expected = cns(clc(number.toString(), cp(1, 1, 2, 2)));

                            assertThat(actual).isEqualTo(expected);

                        }));
    }


    @Test
    public void symbolShouldReturnSymbol() {
        getSymbols().forEach(c ->
                getSymbols()
                        .forEach(symbol -> {
                            final var actual = csys(
                                    clc(c.toString(), cp(1, 1, 1, 1))
                            ).nextValue(symbol);
                            final var expected = csys(clc(symbol.toString(), cp(1, 1, 2, 2)));

                            assertThat(actual).isEqualTo(expected);

                        }));
    }

    @Test
    public void stringSymbolShouldReturnString() {
        getSymbols().forEach(c ->
                getStringSymbols()
                        .forEach(stringSymbol -> {
                            final var actual = csys(
                                    clc(c.toString(), cp(1, 1, 1, 1))
                            ).nextValue(stringSymbol);
                            final var expected = css(clc("", cp(1, 1, 2, 2)), stringSymbol, false);

                            assertThat(actual).isEqualTo(expected);

                        }));
    }


    @Test
    public void getTokenShouldNeverReturnEmpty() {
        getSymbols().forEach(symbol -> {
            final var token = csys(clc(symbol.toString(), cp(1, 1, 1, 1)))
                    .getToken();
            assertThat(token).isNotEmpty();

        });
    }

    @Test
    public void getTokenShouldReturnToken() {
        final var pos = cp(1, 1, 1, 1);
        final var tokens = List.of(
                ct(";", SEMICOLON, pos),
                ct(":", COLON, pos),
                ct("=", ASSIGNATION, pos),
                ct("(", LEFT_PAREN, pos),
                ct(")", RIGHT_PAREN, pos),
                ct("-", MINUS, pos),
                ct("+", PLUS, pos),
                ct("*", MULTIPLY, pos),
                ct("/", DIVIDE, pos)
        );

        tokens.forEach(token -> {
            final var actual = csys(clc(token.getValue(), pos))
                    .getToken();
            final var expected = Optional.of(token);
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo(expected);


        });

    }


}