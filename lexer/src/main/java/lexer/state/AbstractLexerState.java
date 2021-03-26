package lexer.state;

import lexer.model.Token;
import lexer.model.TokenType;
import lexer.state.context.LexerContext;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public abstract class AbstractLexerState implements LexerState {

    protected final LexerContext lexerContext;

    @Override
    public Optional<Token> getToken() {
        return Optional.empty();
    }


    protected Optional<Token> createToken(boolean done, TokenType tokenType) {
        if (!done) return Optional.empty();
        final var token = Token.builder()
                .tokenType(tokenType)
                .position(lexerContext.getPosition())
                .value(lexerContext.getAccumulator())
                .build();
        return Optional.of(token);
    }


    protected Optional<Token> createToken(TokenType tokenType) {
        return createToken(true, tokenType);
    }
}
