package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.List;

import static parser.state.util.StateUtils.addToList;
import static parser.state.util.StateUtils.makeTree;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class IdentifiedPrintState extends AbstractParserState {

    private final List<Token> tokens;

    public IdentifiedPrintState(Token token) {
        this(token, List.of());
    }

    public IdentifiedPrintState(Token token, List<Token> tokens) {
        this.tokens = addToList(tokens, token);
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case PLUS, MINUS, MULTIPLY, DIVIDE -> new OperandPrintState(token, tokens);
            case RIGHT_PAREN -> new RightParenState(makeTree(tokens));
            default -> throw new IllegalStateException();
        };
    }
}
