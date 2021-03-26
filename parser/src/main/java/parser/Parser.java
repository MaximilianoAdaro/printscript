package parser;

import lexer.model.Token;
import parser.node.Node;

import java.util.List;

public interface Parser {
    List<Node> createNodes(final List<Token> tokens);
}
