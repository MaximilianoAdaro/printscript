package state.impls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import node.impl.AssignationNode;
import node.interfaces.Calculable;
import node.interfaces.Declarational;
import state.AbstractParserState;
import state.ParserState;

import java.util.List;

import static state.util.StateUtils.makeTree;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class IdentifiedState extends AbstractParserState {

    private final Declarational declarational;
    private final List<Calculable> calculables;

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case PLUS, MINUS, MULTIPLY, DIVIDE -> new OperandState(declarational, token, calculables);
            case SEMICOLON -> {
                node = new AssignationNode(makeTree(calculables), declarational);
                yield new EmptyState();
            }
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }

}
