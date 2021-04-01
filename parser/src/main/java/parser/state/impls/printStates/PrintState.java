package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
public class PrintState extends AbstractParserState {

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case LEFT_PAREN -> new LeftParenState();
      default -> throw new IllegalStateException();
    };
  }
}
