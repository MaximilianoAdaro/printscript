package state.impls;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import node.impl.IdentifierNode;
import state.AbstractParserState;
import state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
public class IdentifierAssignationState extends AbstractParserState {

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case ASSIGNATION -> new AssignationState(new IdentifierNode(token.getValue()));
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }
}
