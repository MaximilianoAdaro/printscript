package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
public class PrintState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LEFT_PAREN -> new LeftParenState();
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
