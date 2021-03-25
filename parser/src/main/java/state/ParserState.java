package state;

import model.Token;
import node.Node;

import java.util.Optional;

public interface ParserState {

    Optional<Node> getNode();

    ParserState nextToken(Token token);
}
