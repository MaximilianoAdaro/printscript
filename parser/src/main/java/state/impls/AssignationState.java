package state.impls;

import model.Token;
import node.Node;
import node.impl.IdentifierNode;
import state.AbstractParserState;
import state.ParserState;

public class AssignationState extends AbstractParserState {

    private final Node leftNode;

    public AssignationState(Node leftNode) {
        this.leftNode = leftNode;
    }

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
