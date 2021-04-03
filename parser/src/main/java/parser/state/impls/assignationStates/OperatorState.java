package parser.state.impls.assignationStates;

import static parser.state.util.StateUtils.addToList;

import java.util.List;
import lexer.model.Token;
import lombok.*;
import parser.node.interfaces.DeclarationalNode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

@NoArgsConstructor
@AllArgsConstructor
public class OperatorState extends AbstractParserState {

  private DeclarationalNode declarational;
  private List<Token> tokens;

  public OperatorState(DeclarationalNode declarational, Token token, List<Token> tokens) {
    this.declarational = declarational;
    this.tokens = addToList(tokens, token);
  }

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case IDENTIFIER -> new IdentifiedState(declarational, addToList(tokens, token));
      case NUMBER, STRING -> new ValueState(declarational, addToList(tokens, token));
      default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
    };
  }
}
