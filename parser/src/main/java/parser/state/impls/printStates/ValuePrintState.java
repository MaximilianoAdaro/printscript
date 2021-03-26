package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.*;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.Collections;
import java.util.List;

import static parser.state.util.StateUtils.addToList;
import static parser.state.util.StateUtils.makeTree;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValuePrintState extends AbstractParserState {

    private List<Token> tokens;

    public ValuePrintState(Token token) {
        this(token, Collections.emptyList());
    }

    public ValuePrintState(Token token, List<Token> tokens) {
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
