import model.Token;
import node.Node;
import state.ParserState;
import state.impls.EmptyState;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {

    private final List<Node> nodes = new ArrayList<>();
    private ParserState state = new EmptyState();

    @Override
    public List<Node> createNodes(List<Token> tokens) {
        tokens.forEach(this::consumeToken);
        return nodes;
    }

    private void consumeToken(Token t) {
        final var nextState = state.nextToken(t);
        state.getNode().ifPresent(nodes::add);
        state = nextState;
    }

}
