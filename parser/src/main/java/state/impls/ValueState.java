package state.impls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import node.impl.operandNodes.DivisionNode;
import node.impl.operandNodes.MinusNode;
import node.impl.operandNodes.MultiplyNode;
import node.impl.operandNodes.SumNode;
import node.interfaces.Calculable;
import node.interfaces.Declarational;
import state.AbstractParserState;
import state.ParserState;

import java.util.List;

import static state.util.StateUtils.addToList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ValueState extends AbstractParserState {

    private final Declarational declarational;
    private final List<Calculable> calculableList;

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case PLUS -> getOperandState(new SumNode());
            case MINUS -> getOperandState(new MinusNode());
            case MULTIPLY -> getOperandState(new MultiplyNode());
            case DIVIDE -> getOperandState(new DivisionNode());
            case SEMICOLON -> {
//                node = new DeclarationNode<>();
//                node = new AssignationNode<>();
                yield new EmptyState();
            }
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }

    private OperandState getOperandState(Calculable calculable) {
        return new OperandState(declarational, addToList(calculableList, calculable));
    }
}
