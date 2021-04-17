package parser.state.impls.conditionStates;

import lexer.model.Token;
import lombok.EqualsAndHashCode;
import parser.exception.ParserException;
import parser.node.interfaces.Calculable;
import parser.state.AbstractParserState;
import parser.state.BlockManager;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

// @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
// @AllArgsConstructor
public class RightIfParenState extends AbstractParserState {

  public RightIfParenState(Calculable calculable) {
    BlockManager.setCondition(calculable);
  }

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LEFT_CURLY_BRACES -> {
        BlockManager.openBlock();
        yield new EmptyState();
      }
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
