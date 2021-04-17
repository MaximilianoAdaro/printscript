package parser.state.impls.conditionStates;

import lexer.model.Token;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.BlockManager;
import parser.state.ParserState;
import parser.state.impls.EmptyState;
import parser.state.impls.assignationStates.IdentifierAssignationState;
import parser.state.impls.declarationStates.DeclarationState;
import parser.state.impls.printStates.PrintState;

public class RightCurlyBraceState extends AbstractParserState {

  public RightCurlyBraceState() {
    BlockManager.closeBlock();
  }

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LET -> {
        createNode(token);
        yield new DeclarationState(false);
      }
      case CONST -> {
        createNode(token);
        yield new DeclarationState(true);
      }
      case IDENTIFIER -> {
        createNode(token);
        yield new IdentifierAssignationState(token);
      }
      case PRINT -> {
        createNode(token);
        yield new PrintState();
      }
      case EOF -> {
        createNode(token);
        yield new EmptyState();
      }
      case IF -> {
        createNode(token);
        if (!BlockManager.canHaveIf()) throw ParserException.unexpectedToken(token);
        yield new IfState();
      }
      case ELSE -> {
        if (!BlockManager.canHaveElse()) throw ParserException.unexpectedToken(token);
        yield new ElseState();
      }
      default -> throw ParserException.unexpectedToken(token);
    };
  }

  private void createNode(Token token) {
    node = BlockManager.getConditionNode(token.getPosition());
  }
}
