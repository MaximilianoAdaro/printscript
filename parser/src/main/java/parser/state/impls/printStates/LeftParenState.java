package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.NoArgsConstructor;
import parser.node.impl.EmptyNode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
public class LeftParenState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedPrintState(token);
      case NUMBER, STRING -> new ValuePrintState(token);
      case RIGHT_PAREN -> new RightParenState(new EmptyNode());
      default -> throw new IllegalStateException();
    };
  }
}
