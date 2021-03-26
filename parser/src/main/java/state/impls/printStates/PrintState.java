package state.impls.printStates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import state.AbstractParserState;
import state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
public class PrintState extends AbstractParserState {

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case LEFT_PAREN -> new LeftParenState();
            default -> throw new IllegalStateException();
        };
    }
}
