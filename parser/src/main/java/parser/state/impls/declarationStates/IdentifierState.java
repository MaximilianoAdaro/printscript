package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
@AllArgsConstructor
public class IdentifierState extends AbstractParserState {

  private Token token;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case COLON -> new ColonState(this.token);
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
