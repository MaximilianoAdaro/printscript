package parser.state.impls.conditionStates;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.node.impl.EmptyNode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
public class LeftIfParenState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedIfState(token);
      case NUMBER, STRING -> new ValueIfState(token);
      case RIGHT_PAREN -> new RightIfParenState(new EmptyNode());
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
