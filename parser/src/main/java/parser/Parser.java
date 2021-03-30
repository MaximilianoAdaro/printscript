package parser;

import java.util.List;
import lexer.model.Token;
import parser.node.Node;

public interface Parser {
  List<Node> createNodes(final List<Token> tokens);
}
