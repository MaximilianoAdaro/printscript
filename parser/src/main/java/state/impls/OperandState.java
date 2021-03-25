package state.impls;

import model.Token;
import state.AbstractParserState;
import state.ParserState;

public class OperandState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
            case IDENTIFIER: return new IdentifiedState();
            case NUMBER: return new ValueState();
            case STRING: return new ValueState();
        }
        return null;
    }
}
