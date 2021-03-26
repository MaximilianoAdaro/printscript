package state.impls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import node.impl.IdentifierNode;
import node.impl.literalNodes.LiteralNode;
import node.impl.literalNodes.NumberLiteralValue;
import node.impl.literalNodes.StringLiteralValue;
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
    private final List<Calculable> calculableList;

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifiedState(declarational, addToList(calculableList, new IdentifierNode(token.getValue())));
            case NUMBER -> new ValueState(declarational, addToList(calculableList, new LiteralNode(new NumberLiteralValue(Integer.parseInt(token.getValue())))));
            case STRING -> new ValueState(declarational, addToList(calculableList, new LiteralNode(new StringLiteralValue(token.getValue()))));
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }

    private List<Calculable> addNodeToList(Calculable calculable) {
        calculableList.add(calculable);
        return calculableList;
    }
}
