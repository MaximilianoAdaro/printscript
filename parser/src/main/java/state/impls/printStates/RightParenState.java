package state.impls.printStates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import node.impl.PrintNode;
import node.interfaces.Calculable;
import state.AbstractParserState;
import state.ParserState;
import state.impls.EmptyState;

@EqualsAndHashCode(callSuper = true)
@Data
public class RightParenState extends AbstractParserState {

    private final Calculable calculable;

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
