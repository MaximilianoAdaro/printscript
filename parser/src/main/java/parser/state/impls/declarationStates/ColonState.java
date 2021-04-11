package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class ColonState extends AbstractParserState {

  private Token token;
  private boolean isConst;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case NUMBER_TYPE, STRING_TYPE, BOOLEAN_TYPE -> new TypeState(
          this.token, token.getTokenType(), isConst);
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
