package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.interfaces.Calculable;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.Collections;
import java.util.List;

import static parser.state.util.StateUtils.addToList;
import static parser.state.util.StateUtils.makeTree;


@EqualsAndHashCode(callSuper = true)
@Data
public class ValuePrintState extends AbstractParserState {

    private final List<Calculable> calculables;

    public ValuePrintState(Token token) {
        this(token, Collections.emptyList());
    }

    public ValuePrintState(Token token, List<Calculable> calculables) {

        final var literalValue = switch (token.getTokenType()) {
            case NUMBER -> new NumberLiteralValue(Double.parseDouble(token.getValue()));
            case STRING -> new StringLiteralValue(token.getValue());
            default -> throw new IllegalStateException();
        };
        this.calculables = addToList(calculables, new LiteralNode(literalValue));
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
