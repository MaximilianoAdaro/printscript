package state.impls.declarationStates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import state.AbstractParserState;
import state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
public class DeclarationState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifierState(token);
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }
}
