package lexer.state.context;

import org.junit.Test;

import static lexer.utils.TestUtils.clc;
import static lexer.utils.TestUtils.cp;
import static org.assertj.core.api.Assertions.assertThat;

public class LexerContextTest {

    @Test
    public void reset() {
        final var actual = clc("hello", cp(2, 2, 1, 5)).reset(' ');
        final var expected = clc(" ", cp(2, 2, 6, 6));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void reset2() {
        final var actual = clc("hello", cp(2, 2, 1, 5)).reset();
        final var expected = clc("", cp(2, 2, 6, 6));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void reset3() {
        final var actual = clc("hello", cp(2, 2, 5, 9)).reset('a');
        final var expected = clc("a", cp(2, 2, 10, 10));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void changeLine() {
        final var actual = clc("hello", cp(2, 2, 5, 9)).changeLine();
        final var expected = clc("", cp(3, 3, 0, 0));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void addCharacter() {
        final var actual = clc("hello", cp(2, 2, 5, 9)).addCharacter('1');
        final var expected = clc("hello1", cp(2, 2, 5, 10));
        assertThat(actual).isEqualTo(expected);

    }
}