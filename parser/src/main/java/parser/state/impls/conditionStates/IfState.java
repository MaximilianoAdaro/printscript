package parser.state.impls.conditionStates;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
public class IfState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LEFT_PAREN -> new LeftIfParenState();
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
