package state.impls;

import model.Token;
import node.impl.IdentifierNode;
import node.impl.literalNodes.LiteralNode;
import node.impl.literalNodes.NumberLiteralValue;
import node.impl.literalNodes.StringLiteralValue;
import node.interfaces.Declarational;
import state.AbstractParserState;
import state.ParserState;

import java.util.Collections;

public class AssignationState extends AbstractParserState {

    private final Declarational declarational;

    public AssignationState(Declarational declarational) {
        this.declarational = declarational;
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifiedState(declarational, Collections.singletonList(new IdentifierNode(token.getValue())));
            case NUMBER -> new ValueState(declarational, Collections.singletonList(new LiteralNode(new NumberLiteralValue(Integer.parseInt(token.getValue())))));
            case STRING -> new ValueState(declarational, Collections.singletonList(new LiteralNode(new StringLiteralValue(token.getValue()))));
            default -> null;
        };
    }
}
