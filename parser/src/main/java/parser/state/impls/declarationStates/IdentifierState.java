package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

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
