import model.Position;
import model.Token;
import model.TokenType;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LexerImplTest {


    @Test
    public void testLetToken() {
        final var let = "let";

        final var expected = List.of(
                new Token(
                        TokenType.LET,
                        "let",
                        new Position(0, 0, 0, 0))
        );

        final var tokens = new LexerImpl().createTokens(let);

        assertThat(tokens)
                .hasSize(1)
                .isEqualTo(expected);

    }


}