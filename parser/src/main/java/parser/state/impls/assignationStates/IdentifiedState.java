package parser.state.impls.assignationStates;

import static parser.state.util.StateUtils.makeTree;

import java.util.List;
import lexer.model.Token;
import lombok.*;
import parser.node.impl.AssignationNode;
import parser.node.interfaces.Declarational;
import parser.state.AbstractParserState;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

@NoArgsConstructor
@AllArgsConstructor
public class IdentifiedState extends AbstractParserState {

  private Declarational declarational;
  private List<Token> tokens;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case PLUS, MINUS, MULTIPLY, DIVIDE -> new OperatorState(declarational, token, tokens);
      case SEMICOLON -> {
        node = new AssignationNode(makeTree(tokens), declarational);
        yield new EmptyState();
      }
      default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
    };
  }
}
