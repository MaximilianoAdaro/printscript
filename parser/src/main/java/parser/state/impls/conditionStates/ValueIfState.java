package parser.state.impls.conditionStates;

import static parser.state.util.StateUtils.addToList;
import static parser.state.util.StateUtils.makeTree;

import java.util.Collections;
import java.util.List;
import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
public class ValueIfState extends AbstractParserState {

  private List<Token> tokens;

  public ValueIfState(Token token) {
    this(token, Collections.emptyList());
  }

  public ValueIfState(Token token, List<Token> tokens) {
    this.tokens = addToList(tokens, token);
  }

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case PLUS, MINUS, MULTIPLY, DIVIDE, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL -> new OperatorIfState(
          token, tokens);
      case RIGHT_PAREN -> new RightIfParenState(makeTree(tokens));
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
