package parser.state.impls.conditionStates;

import static parser.state.util.CalculableUtils.BLOCK_COUNTER;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.node.interfaces.Calculable;
import parser.state.AbstractParserState;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

@NoArgsConstructor
@AllArgsConstructor
public class RightIfParenState extends AbstractParserState {

  private Calculable calculable;

  @Override
  public ParserState nextToken(Token token) {
    switch (token.getTokenType()) {
      case LEFT_CURLY_BRACES -> {
        BLOCK_COUNTER++;
        return new EmptyState();
      }
      default -> throw ParserException.unexpectedToken(token);
    }
  }
}
