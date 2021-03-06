package parser.state.impls.conditionStates;

import lexer.model.Token;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.BlockManager;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

public class ElseState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LEFT_CURLY_BRACES -> {
        BlockManager.openElseBlock();
        yield new EmptyState();
      }
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
