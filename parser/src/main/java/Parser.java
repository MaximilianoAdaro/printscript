import model.Token;
import node.interfaces.Node;

import java.util.List;

public interface Parser {
    List<Node> createNodes(final List<Token> tokens);
}
