package parser.state.impls;

import static parser.state.util.StateUtils.makeTree;

import java.util.List;
import lexer.model.Token;
import lombok.*;
import parser.node.impl.AssignationNode;
import parser.node.interfaces.Declarational;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValueState extends AbstractParserState {

  private Declarational declarational;
  private List<Token> tokens;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case PLUS, MINUS, MULTIPLY, DIVIDE -> new OperandState(declarational, token, tokens);
      case SEMICOLON -> {
        node = new AssignationNode(makeTree(tokens), declarational);
        yield new EmptyState();
      }
      default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
    };
  }
}
