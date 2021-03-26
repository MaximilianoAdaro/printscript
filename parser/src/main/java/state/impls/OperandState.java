package state.impls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import node.impl.IdentifierNode;
import node.impl.literalNodes.LiteralNode;
import node.impl.literalNodes.NumberLiteralValue;
import node.impl.literalNodes.StringLiteralValue;
import node.impl.operandNodes.*;
import node.interfaces.Calculable;
import node.interfaces.Declarational;
import state.AbstractParserState;
import state.ParserState;

import java.util.List;

import static state.util.StateUtils.addToList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class OperandState extends AbstractParserState {

    private final Declarational declarational;
    private final List<Calculable> calculables;

    public OperandState(Declarational declarational, Token token, List<Calculable> calculables) {
        final OperandNode calculabe = switch (token.getTokenType()) {
            case PLUS -> new SumNode();
            case MINUS -> new MinusNode();
            case MULTIPLY -> new MultiplyNode();
            case DIVIDE -> new DivisionNode();
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
        this.declarational = declarational;
        this.calculables = addToList(calculables, calculabe);
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifiedState(declarational, addToList(calculables, new IdentifierNode(token.getValue())));
            case NUMBER -> getValueState(new LiteralNode(new NumberLiteralValue(Double.parseDouble(token.getValue()))));
            case STRING -> getValueState(new LiteralNode(new StringLiteralValue(token.getValue())));
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }

    private ValueState getValueState(LiteralNode literalNode) {
        return new ValueState(declarational, addToList(calculables, literalNode));
    }
}
