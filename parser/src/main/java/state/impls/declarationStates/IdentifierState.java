package state.impls.declarationStates;

import model.Token;
import state.AbstractParserState;
import state.ParserState;

public class IdentifierState extends AbstractParserState {

    private final Token token;

    public IdentifierState(Token token) {
        this.token = token;
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case COLON -> new ColonState(this.token);
            default -> null;
        };
    }
}
