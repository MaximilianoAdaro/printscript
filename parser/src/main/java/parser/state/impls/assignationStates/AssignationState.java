package parser.state.impls.assignationStates;

import java.util.Collections;
import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.node.impl.declarationNodes.DeclarationalNode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
@AllArgsConstructor
public class AssignationState extends AbstractParserState {

  private DeclarationalNode declarational;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedState(declarational, Collections.singletonList(token));
      case NUMBER, STRING -> new ValueState(declarational, Collections.singletonList(token));
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
