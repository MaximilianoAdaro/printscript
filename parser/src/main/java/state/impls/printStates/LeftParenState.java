package state.impls.printStates;

import model.Token;
import state.AbstractParserState;
import state.ParserState;

public class LeftParenState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifiedPrintState();
            case NUMBER -> new ValuePrintState();
            case STRING -> new ValuePrintState();
            case RIGHT_PAREN -> new RightParenState();
            default -> null;
        };
    }
}
