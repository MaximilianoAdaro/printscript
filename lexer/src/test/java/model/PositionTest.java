package model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestUtils.cp;

public class PositionTest {


    @Test
    public void reset() {
        final var expected = cp(1, 1, 2, 2);
        final var actual = cp(1, 1, 1, 1).reset();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void newLine() {
        final var expected = cp(2, 2, 0, 0);
        final var actual = cp(1, 1, 1, 1).newLine();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void advance() {
        final var expected = cp(1, 1, 1, 2);
        final var actual = cp(1, 1, 1, 1).advance();

        assertThat(actual).isEqualTo(expected);
    }
}