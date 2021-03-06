package parser.state.impls.printStates;

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
public class OperatorPrintState extends AbstractParserState {

  private List<Token> tokens;

  public OperatorPrintState(Token token, List<Token> tokens) {
    this.tokens = addToList(tokens, token);
  }

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedPrintState(token, tokens);
      case NUMBER, STRING -> new ValuePrintState(token, tokens);
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
