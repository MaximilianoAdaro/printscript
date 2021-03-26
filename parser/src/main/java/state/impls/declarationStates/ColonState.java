package state.impls.declarationStates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import state.AbstractParserState;
import state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
public class ColonState extends AbstractParserState {

    private final Token token;

    public ColonState(Token token) {
        this.token = token;
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case NUMBER_TYPE, STRING_TYPE -> new TypeState(this.token, token.getTokenType());
            default -> null;
        };
    }
}