package state.impls;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestUtils.*;

public class EmptyStateTest {

    @Test
    public void newLineShouldReturnEmpty() {

        final var actual = ces(clc("", cp(1, 1, 1, 1)))
                .nextValue('\n');

        final var expected = ces(clc("", cp(2, 2, 0, 0)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whiteSpaceShouldReturnEmpty() {
        final var actual = ces(clc("", cp(1, 1, 1, 1)))
                .nextValue(' ');

        final var expected = ces(clc("", cp(1, 1, 2, 2)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void numberShouldReturnNumber() {
        final var actual = ces(clc("", cp(1, 1, 1, 1)))
                .nextValue('1');

        final var expected = cns(clc("1", cp(1, 1, 2, 2)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void tickShouldReturnString() {
        final var actual = ces(clc("", cp(1, 1, 1, 1)))
                .nextValue('\'');

        final var expected = css(
                clc("'", cp(1, 1, 2, 2)),
                '\'',
                false
        );

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void doubleTickShouldReturnString() {
        final var actual = ces(clc("", cp(1, 1, 1, 1)))
                .nextValue('"');

        final var expected = css(
                clc("\"", cp(1, 1, 2, 2)),
                '"',
                false
        );

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void symbolShouldReturnSymbol() {
        List.of('=', '+', '-', '*', '/', ':', ';').forEach(s -> {

            final var actual = ces(clc("", cp(1, 1, 1, 1)))
                    .nextValue(s);

            final var expected = csys(clc(s.toString(), cp(1, 1, 2, 2)));

            assertThat(actual).isEqualTo(expected);

        });
    }

    @Test
    public void letterShouldReturnText() {
        IntStream.concat(
                IntStream.rangeClosed('a', 'z'),
                IntStream.rangeClosed('A', 'Z')
        ).mapToObj(c -> (char) c)
                .forEach(s -> {

                    final var actual = ces(clc("", cp(1, 1, 1, 1)))
                            .nextValue(s);

                    final var expected = cts(clc(s.toString(), cp(1, 1, 2, 2)));

                    assertThat(actual).isEqualTo(expected);

                });
    }


}