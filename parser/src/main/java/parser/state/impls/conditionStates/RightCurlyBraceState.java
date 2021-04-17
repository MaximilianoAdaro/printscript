package parser.state.impls.conditionStates;

import lexer.model.Token;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

public class RightCurlyBraceState extends AbstractParserState {
  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case ELSE -> new ElseState();
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
