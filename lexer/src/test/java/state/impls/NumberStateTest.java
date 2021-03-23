package state.impls;

import model.TokenType;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestUtils.*;

public class NumberStateTest {

    @Test
    public void numberShouldReturnNumber() {
        getNumbers()
                .forEach(c -> {
                    final var actual = cns(clc("1", cp(1, 1, 1, 1)))
                            .nextValue(c);
                    final var expected = cns(clc("1" + c, cp(1, 1, 1, 2)));

                    assertThat(actual).isEqualTo(expected);

                });
    }

    @Test
    public void symbolShouldReturnSymbol() {
        getSymbols()
                .forEach(c -> {
                    final var actual = cns(clc("1", cp(1, 1, 1, 1)))
                            .nextValue(c);
                    final var expected = csys(clc(c.toString(), cp(1, 1, 2, 2)));

                    assertThat(actual).isEqualTo(expected);

                });
    }

    @Test
    public void newlineShouldReturnEmpty() {
        final var actual = cns(clc("1", cp(1, 1, 1, 1)))
                .nextValue('\n');
        final var expected = ces(clc("", cp(2, 2, 0, 0)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whitespaceShouldReturnEmpty() {
        getWhitespace()
                .forEach(c -> {
                    final var actual = cns(clc("1", cp(1, 1, 1, 1)))
                            .nextValue(c);
                    final var expected = ces(clc("", cp(1, 1, 2, 2)));
                    assertThat(actual).isEqualTo(expected);

                });

    }


    @Test
    public void ifNextCharIsNumberGetTokenShouldReturnEmpty() {
        getNumbers().forEach(number -> {
            final var numberState = cns(clc("1234", cp(1, 1, 1, 4)));
            numberState.nextValue(number);
            final var actual = numberState.getToken();
            assertThat(actual).isEmpty();

        });
    }

    @Test
    public void ifNextCharIsNotNumberGetTokenShouldReturnToken() {
        getSymbolsNewlineAndWhitespace().forEach(c -> {
            final var pos = cp(1, 1, 1, 4);
            final var numberState = cns(clc("1234", pos));
            numberState.nextValue(c);
            final var actual = numberState.getToken();
            final var expected = Optional.of(ct("1234", TokenType.NUMBER, pos));
            assertThat(actual)
                    .isNotEmpty()
                    .isEqualTo(expected);

        });
    }
}