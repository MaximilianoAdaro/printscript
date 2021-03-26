package parser.state;

import lexer.model.Token;
import parser.node.Node;

import java.util.Optional;


public interface ParserState {

    Optional<Node> getNode();

    ParserState nextToken(Token token);
}
