package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.exception.ParserException;
import parser.node.impl.PrintNode;
import parser.node.interfaces.Calculable;
import parser.state.AbstractParserState;
import parser.state.BlockManager;
import parser.state.ParserState;
import parser.state.impls.EmptyState;

@NoArgsConstructor
@AllArgsConstructor
public class RightParenState extends AbstractParserState {

  private Calculable calculable;

  @Override
  public ParserState nextToken(Token token) {
    return switch (token.getTokenType()) {
      case SEMICOLON -> {
        final var printNode = new PrintNode(token.getPosition(), calculable);
        if (BlockManager.isInsideBlock()) BlockManager.addToBlock(printNode);
        else node = printNode;
        yield new EmptyState();
      }
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
