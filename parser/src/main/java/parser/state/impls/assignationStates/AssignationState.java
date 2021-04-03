package parser.state.impls.assignationStates;

import java.util.Collections;
import lexer.model.Token;
import lombok.*;
import parser.node.interfaces.Declarational;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
@AllArgsConstructor
public class AssignationState extends AbstractParserState {

  private Declarational declarational;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedState(declarational, Collections.singletonList(token));
      case NUMBER, STRING -> new ValueState(declarational, Collections.singletonList(token));
      default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
    };
  }
}
