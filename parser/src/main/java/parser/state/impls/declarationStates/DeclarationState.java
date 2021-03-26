package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

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
