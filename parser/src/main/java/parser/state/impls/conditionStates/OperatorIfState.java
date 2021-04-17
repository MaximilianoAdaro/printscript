package parser.state.impls.conditionStates;

import static parser.state.util.StateUtils.addToList;

import java.util.List;
import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
@AllArgsConstructor
public class OperatorIfState extends AbstractParserState {

  private List<Token> tokens;

  public OperatorIfState(Token token, List<Token> tokens) {
    this.tokens = addToList(tokens, token);
  }

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedIfState(token, tokens);
      case NUMBER, STRING -> new ValueIfState(token, tokens);
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
