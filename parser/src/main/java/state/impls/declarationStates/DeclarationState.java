package state.impls.declarationStates;

import model.Token;
import node.impl.IdentifierNode;
import state.AbstractParserState;
import state.ParserState;

public class DeclarationState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
            case IDENTIFIER: return new IdentifierState(token);
        }
        return null;
    }
}
