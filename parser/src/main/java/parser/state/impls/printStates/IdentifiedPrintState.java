package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.IdentifierNode;
import parser.node.interfaces.Calculable;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.List;

import static parser.state.util.StateUtils.addToList;
import static parser.state.util.StateUtils.makeTree;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class IdentifiedPrintState extends AbstractParserState {

    private final List<Calculable> calculables;

    public IdentifiedPrintState(Token token) {
        this(token, List.of());
    }

    public IdentifiedPrintState(Token token, List<Calculable> calculables) {
        this.calculables = addToList(calculables, new IdentifierNode(token.getValue()));
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case PLUS, MINUS, MULTIPLY, DIVIDE -> new OperandPrintState(token, calculables);
            case RIGHT_PAREN -> new RightParenState(makeTree(calculables));
            default -> throw new IllegalStateException();
        };
    }
}
