package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.operandNodes.DivisionNode;
import parser.node.impl.operandNodes.MinusNode;
import parser.node.impl.operandNodes.MultiplyNode;
import parser.node.impl.operandNodes.SumNode;
import parser.node.interfaces.Calculable;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.List;

import static parser.state.util.StateUtils.addToList;

@EqualsAndHashCode(callSuper = true)
@Data
public class OperandPrintState extends AbstractParserState {

    private final List<Calculable> calculables;

    public OperandPrintState(Token token, List<Calculable> calculables) {
        final var calculabe = switch (token.getTokenType()) {
            case PLUS -> new SumNode();
            case MINUS -> new MinusNode();
            case MULTIPLY -> new MultiplyNode();
            case DIVIDE -> new DivisionNode();
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
        this.calculables = addToList(calculables, calculabe);
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifiedPrintState(token, calculables);
            case NUMBER, STRING -> new ValuePrintState(token, calculables);
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }
}
