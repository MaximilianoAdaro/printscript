package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DeclarationState extends AbstractParserState {

  private boolean isConst;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifierState(token, isConst);
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
