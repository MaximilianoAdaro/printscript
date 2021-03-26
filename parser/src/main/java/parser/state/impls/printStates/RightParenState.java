package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.*;
import parser.node.impl.PrintNode;
import parser.node.interfaces.Calculable;
import parser.state.AbstractParserState;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RightParenState extends AbstractParserState {

    private Calculable calculable;

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case SEMICOLON -> {
                node = new PrintNode(calculable);
                yield new EmptyState();
            }
            default -> throw new IllegalStateException();
        };
    }
}
