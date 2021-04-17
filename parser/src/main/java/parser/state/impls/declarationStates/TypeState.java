package parser.state.impls.declarationStates;

import lexer.model.Position;
import lexer.model.Token;
import lexer.model.TokenType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.exception.ParserException;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.state.AbstractParserState;
import parser.state.BlockManager;
import parser.state.ParserState;
import parser.state.impls.EmptyState;
import parser.state.impls.assignationStates.AssignationState;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TypeState extends AbstractParserState {

  private Token token;
  private TokenType tokenType;
  private boolean isConst;

  @Override
  public ParserState nextToken(Token t) {
    final var declarationNode = getDeclarationNode(t.getPosition());
    return switch (t.getTokenType()) {
      case ASSIGNATION -> new AssignationState(declarationNode);
      case SEMICOLON -> {
        if (isConst) throw ParserException.unexpectedToken(t);
        if (BlockManager.isInsideBlock()) BlockManager.addToBlock(declarationNode);
        else node = declarationNode;
        yield new EmptyState();
      }
      default -> throw ParserException.unexpectedToken(token);
    };
  }

  private DeclarationNode getDeclarationNode(Position position) {
    TypeValue typeValue =
        switch (tokenType) {
          case STRING_TYPE -> TypeValue.STRING;
          case NUMBER_TYPE -> TypeValue.NUMBER;
          case BOOLEAN_TYPE -> TypeValue.BOOLEAN;
          default -> throw new IllegalStateException("Unexpected value: " + tokenType);
        };
    return new DeclarationNode(
        position, typeValue, new IdentifierNode(position, token.getValue()), isConst);
  }
}
