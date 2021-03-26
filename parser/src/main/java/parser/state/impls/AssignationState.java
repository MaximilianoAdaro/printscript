package parser.state.impls;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.IdentifierNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.interfaces.Declarational;
import parser.node.interfaces.LiteralValue;
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
