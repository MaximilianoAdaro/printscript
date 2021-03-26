package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

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
