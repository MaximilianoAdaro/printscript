import model.Token;
import node.Node;
import node.streams.TokenStream;
import node.streams.TokenStreamImpl;

import java.util.List;

public class ParserImpl implements Parser {

    @Override
    public List<Node> createNodes(List<Token> tokens) {

        TokenStream tokenStream = new TokenStreamImpl(tokens);


        return null;
    }
}
