package state.impls.declarationStates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import state.AbstractParserState;
import state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
public class IdentifierState extends AbstractParserState {

    private final Token token;

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case COLON -> new ColonState(this.token);
            default -> null;
        };
    }
}
