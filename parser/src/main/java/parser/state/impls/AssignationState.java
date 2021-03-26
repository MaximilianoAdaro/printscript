package parser.state.impls;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.interfaces.Declarational;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssignationState extends AbstractParserState {

    private final Declarational declarational;

    public AssignationState(Declarational declarational) {
        this.declarational = declarational;
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifiedState(declarational, Collections.singletonList(token));
            case NUMBER, STRING -> new ValueState(declarational, Collections.singletonList(token));
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }

}
