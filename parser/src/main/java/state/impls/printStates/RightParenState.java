package state.impls.printStates;

import model.Token;
import node.impl.PrintNode;
import state.AbstractParserState;
import state.ParserState;

public class RightParenState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
            case SEMICOLON: {
//                node = new PrintNode();
            }
        }
        return null;
    }
}
