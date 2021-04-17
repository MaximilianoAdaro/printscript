package parser.state.impls;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.BlockManager;
import parser.state.ParserState;
import parser.state.impls.assignationStates.IdentifierAssignationState;
import parser.state.impls.conditionStates.IfState;
import parser.state.impls.conditionStates.RightCurlyBraceState;
import parser.state.impls.declarationStates.DeclarationState;
import parser.state.impls.printStates.PrintState;

@NoArgsConstructor
public class EmptyState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LET -> new DeclarationState(false);
      case CONST -> new DeclarationState(true);
      case IDENTIFIER -> new IdentifierAssignationState(token);
      case PRINT -> new PrintState();
      case IF -> {
        if (!BlockManager.canHaveIf()) throw ParserException.unexpectedToken(token);
        yield new IfState();
      }
      case RIGHT_CURLY_BRACES -> {
        if (!BlockManager.isInsideBlock()) throw ParserException.unexpectedToken(token);
        yield new RightCurlyBraceState();
      }
      case EOF -> new EmptyState();
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
