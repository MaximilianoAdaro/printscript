package parser.state.impls;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.IdentifierNode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

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