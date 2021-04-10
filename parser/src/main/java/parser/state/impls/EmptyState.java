package parser.state.impls;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;
import parser.state.impls.assignationStates.IdentifierAssignationState;
import parser.state.impls.declarationStates.DeclarationState;
import parser.state.impls.printStates.PrintState;

@NoArgsConstructor
public class EmptyState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LET -> new DeclarationState();
      case IDENTIFIER -> new IdentifierAssignationState(token);
      case PRINT -> new PrintState();
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
