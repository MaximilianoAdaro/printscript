package parser.state.impls.conditionStates;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
public class LeftIfParenState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedIfState(token);
      case NUMBER, STRING, BOOLEAN -> new ValueIfState(token);
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
