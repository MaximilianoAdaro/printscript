package state;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Token;
import model.TokenType;
import state.context.LexerContext;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public abstract class AbstractLexerState implements LexerState {

    protected final LexerContext lexerContext;

    @Override
    public Optional<Token> getToken() {
        return Optional.empty();
    }

    // todo: esta mal, estoy mutando context anters de pedir el token; hay que cambiar
    protected Optional<Token> getToken(boolean done, TokenType tokenType) {
        if (!done) return Optional.empty();
        final var token = Token.builder()
                .tokenType(tokenType)
                .position(lexerContext.getPosition())
                .value(lexerContext.getAccumulator())
                .build();
        return Optional.of(token);
    }

    protected boolean isSemicolon(Character c) {
        return c == ';';
    }

    protected boolean isMathSymbol(Character c) {
        return List.of('=', '+', '-', '*', '/').contains(c);
    }

    protected boolean isSymbol(Character c) {
        return List.of('(', ')', ':', ';').contains(c);
    }

    protected boolean isStringSymbol(Character c) {
        return List.of('"', '\'').contains(c);
    }

    protected boolean isAnySymbol(Character c) {
        return isMathSymbol(c) || isMathSymbol(c);
    }

    protected boolean isNumber(Character c) {
        return Character.isDigit(c);
    }

    protected boolean isBlank(Character c) {
        return Character.isWhitespace(c);
    }

    protected boolean isLetter(Character c) {
        return Character.isLetter(c);
    }


}
