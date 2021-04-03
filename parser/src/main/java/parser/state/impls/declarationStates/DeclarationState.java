package parser.state.impls.declarationStates;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
public class DeclarationState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifierState(token);
      default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
    };
  }
}
