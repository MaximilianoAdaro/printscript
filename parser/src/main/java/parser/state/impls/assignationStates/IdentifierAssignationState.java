package parser.state.impls.assignationStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
@AllArgsConstructor
public class IdentifierAssignationState extends AbstractParserState {

  private Token token;

  @Override
  public ParserState nextToken(Token t) {
    return switch (t.getTokenType()) {
      case ASSIGNATION -> new AssignationState(
          new IdentifierNode(token.getPosition(), token.getValue()));
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
