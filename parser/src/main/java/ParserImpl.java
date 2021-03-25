import model.Token;
import node.Node;
import node.streams.TokenStream;
import node.streams.TokenStreamImpl;
import state.LexerState;
import state.ParserState;
import state.context.LexerContext;
import state.impls.EmptyState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParserImpl implements Parser {

    private final List<Node> nodes = new ArrayList<>();
    private ParserState state = new EmptyState();

    @Override
    public List<Node> createNodes(List<Token> tokens) {

        TokenStream tokenStream = new TokenStreamImpl(tokens);
        tokens.forEach(this::consumeToken);

        return null;
    }

    private void consumeToken(Token t) {
        final var nextState = state.nextToken(t);
        state.getNode().ifPresent(nodes::add);
        state = nextState;
    }

}
