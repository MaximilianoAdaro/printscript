package parser.state;

import java.util.Optional;
import lexer.model.Token;
import parser.node.Node;

public interface ParserState {

  Optional<Node> getNode();

  ParserState nextToken(Token token);
}
