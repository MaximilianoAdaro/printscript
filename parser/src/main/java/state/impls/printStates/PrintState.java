package state.impls.printStates;

import model.Token;
import state.AbstractParserState;
import state.ParserState;

public class PrintState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
            case LEFT_PAREN: return new LeftParenState();
            case SEMICOLON: {
//                node = new PrintNode();
            }
        }
        return null;
    }
}
