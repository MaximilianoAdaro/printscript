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
import parser.state.ParserState;
import parser.state.impls.EmptyState;

@NoArgsConstructor
@AllArgsConstructor
public class ValueState extends AbstractParserState {

  private DeclarationalNode declarational;
  private List<Token> tokens;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case PLUS, MINUS, MULTIPLY, DIVIDE, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL -> new OperatorState(
          declarational, token, tokens);
      case SEMICOLON -> {
        node = new AssignationNode(token.getPosition(), makeTree(tokens), declarational);
        yield new EmptyState();
      }
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
