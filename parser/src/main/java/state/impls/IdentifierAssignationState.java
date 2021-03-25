package state.impls;

import model.Token;
import state.AbstractParserState;
import state.ParserState;

public class IdentifierAssignationState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
//            case ASSIGNATION: return new AssignationState();
        }
        return null;
    }
}
