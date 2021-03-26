package parser.state.impls;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.AssignationNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.List;

import static parser.state.util.StateUtils.makeTree;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ValueState extends AbstractParserState {

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
