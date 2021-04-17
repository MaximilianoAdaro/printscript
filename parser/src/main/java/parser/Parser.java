package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lexer.model.Position;
import lexer.model.Token;
import lexer.model.TokenType;
import lombok.val;
import parser.exception.ParserException;
import parser.node.Node;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

public class Parser {

  private final List<Node> nodes = new ArrayList<>();
  private ParserState state = new EmptyState();

  private Parser() {}

  public static List<Node> parse(List<Token> tokens) {
    return new Parser().createNodes(tokens);
  }

  private List<Node> createNodes(List<Token> tokens) {
    boolean canFinish = true;
    for (Token token : tokens) {
      canFinish = consumeToken(token);
    }
    canFinish = canFinish || consumeToken(new Token(TokenType.EOF, "", Position.builder().build()));
    if (canFinish) return nodes;
    else throw ParserException.unexpectedToken(tokens.get(tokens.size() - 1));
  }

  private boolean consumeToken(Token t) {
    boolean canFinish = false;
    val nextState = state.nextToken(t);
    Optional<Node> node = state.getNode();
    if (node.isPresent()) {
      nodes.add(node.get());
      canFinish = true;
    }
    state = nextState;
    return canFinish;
  }
}
