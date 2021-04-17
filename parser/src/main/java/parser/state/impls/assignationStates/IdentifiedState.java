package parser.state.impls.assignationStates;

import static parser.state.util.StateUtils.makeTree;

import java.util.List;
import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.node.impl.AssignationNode;
import parser.node.impl.declarationNodes.DeclarationalNode;
import parser.state.AbstractParserState;
import parser.state.BlockManager;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

@NoArgsConstructor
@AllArgsConstructor
public class IdentifiedState extends AbstractParserState {

  private DeclarationalNode declarational;
  private List<Token> tokens;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case PLUS, MINUS, MULTIPLY, DIVIDE, GREATER, GREATER_EQUAL, LESS_EQUAL, LESS -> new OperatorState(
          declarational, token, tokens);
      case SEMICOLON -> {
        final var assignationNode =
            new AssignationNode(token.getPosition(), makeTree(tokens), declarational);
        if (BlockManager.isInsideBlock()) BlockManager.addToBlock(assignationNode);
        else node = assignationNode;
        yield new EmptyState();
      }
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
