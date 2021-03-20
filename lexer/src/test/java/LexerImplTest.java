import model.Position;
import model.Token;
import model.TokenType;
import org.junit.Test;

import java.util.List;

import static model.TokenType.*;
import static org.assertj.core.api.Assertions.assertThat;


public class LexerImplTest {


    private Token createTokenWithPositionZero(TokenType tokenType, String value) {
        return Token.builder()
                .tokenType(tokenType)
                .value(value)
                .position(new Position(0, 0, 0, 0))
                .build();
    }

    @Test
    public void testIndividualTokens() {
        final var expectedTokens = List.of(
                createTokenWithPositionZero(SEMICOLON, ";"),
                createTokenWithPositionZero(COLON, ":"),
                createTokenWithPositionZero(ASSIGNATION, "="),
                createTokenWithPositionZero(MINUS, "-"),
                createTokenWithPositionZero(MINUS, "-"),
                createTokenWithPositionZero(PLUS, "+"),
                createTokenWithPositionZero(MULTIPLY, "*"),
                createTokenWithPositionZero(DIVIDE, "/"),
                createTokenWithPositionZero(IDENTIFIER, "identifier"),
                createTokenWithPositionZero(IDENTIFIER, "variable"),
                createTokenWithPositionZero(STRING, "'This is a string'"),
                createTokenWithPositionZero(STRING, "\"This is a string\""),
                createTokenWithPositionZero(NUMBER, "1"),
                createTokenWithPositionZero(NUMBER, "56348563"),
                createTokenWithPositionZero(PRINT, "println"),
                createTokenWithPositionZero(LET, "let")
        );

        expectedTokens.forEach(token -> {
            final var tokens = new LexerImpl().createTokens(token.getValue());

            assertThat(tokens)
                    .hasSize(1)
                    .isEqualTo(List.of(token));
        });
    }

    @Test
    public void testGroupedTokens() {
        final var expectedTokens = List.of(
                createTokenWithPositionZero(LET, "let"),
                createTokenWithPositionZero(IDENTIFIER, "x"),
                createTokenWithPositionZero(ASSIGNATION, "="),
                createTokenWithPositionZero(NUMBER, "2")
        );

        final var text1 = "let x = 2";
        final var tokens1 = new LexerImpl().createTokens(text1);

        assertThat(tokens1)
                .hasSize(4)
                .isEqualTo(expectedTokens);


        final var text2 = "let x=2";
        final var tokens2 = new LexerImpl().createTokens(text2);

        assertThat(tokens2)
                .hasSize(4)
                .isEqualTo(expectedTokens);


        final var text3 = "let x =2";
        final var tokens3 = new LexerImpl().createTokens(text3);

        assertThat(tokens3)
                .hasSize(4)
                .isEqualTo(expectedTokens);


        final var text4 = "let x= 2";
        final var tokens4 = new LexerImpl().createTokens(text4);

        assertThat(tokens4)
                .hasSize(4)
                .isEqualTo(expectedTokens);
    }


}