package state.impls.printStates;

import model.Token;
import state.AbstractParserState;
import state.ParserState;
import state.impls.IdentifiedState;
import state.impls.ValueState;

public class OperandPrintState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
            case IDENTIFIER: return new IdentifiedPrintState();
            case NUMBER: return new ValuePrintState();
            case STRING: return new ValuePrintState();
        }
        return null;
    }
}
