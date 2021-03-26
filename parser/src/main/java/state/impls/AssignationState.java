package state.impls;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import node.impl.IdentifierNode;
import node.impl.literalNodes.LiteralNode;
import node.impl.literalNodes.NumberLiteralValue;
import node.impl.literalNodes.StringLiteralValue;
import node.interfaces.Declarational;
import node.interfaces.LiteralValue;
import state.AbstractParserState;
import state.ParserState;

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
            case IDENTIFIER -> new IdentifiedState(declarational, Collections.singletonList(new IdentifierNode(token.getValue())));
            case NUMBER -> getValueState(new NumberLiteralValue(Double.parseDouble(token.getValue())));
            case STRING -> getValueState(new StringLiteralValue(token.getValue()));
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }

    private ValueState getValueState(LiteralValue literalValue) {
        return new ValueState(declarational, Collections.singletonList(new LiteralNode(literalValue)));
    }
}
