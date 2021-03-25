package state.impls.printStates;

import model.Token;
import state.AbstractParserState;
import state.ParserState;

public class ValuePrintState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
            case PLUS: return new OperandPrintState();
            case MINUS: return new OperandPrintState();
            case MULTIPLY: return new OperandPrintState();
            case DIVIDE: return new OperandPrintState();
        }
        return null;
    }
}
