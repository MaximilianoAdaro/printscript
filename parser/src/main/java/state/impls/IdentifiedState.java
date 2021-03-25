package state.impls;

import model.Token;
import node.impl.AssignationNode;
import node.impl.DeclarationNode;
import state.AbstractParserState;
import state.ParserState;

public class IdentifiedState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        switch (token.getTokenType()) {
            case PLUS: return new OperandState();
            case MINUS: return new OperandState();
            case MULTIPLY: return new OperandState();
            case DIVIDE: return new OperandState();
            case SEMICOLON: {
//                node = new DeclarationNode<>();
//                node = new AssignationNode<>();
                return new EmptyState();
            }
        }
        return null;
    }
}
