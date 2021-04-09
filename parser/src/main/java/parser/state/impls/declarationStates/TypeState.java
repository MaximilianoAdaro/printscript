package parser.state.impls.declarationStates;

import lexer.model.Token;
import lexer.model.TokenType;
import lombok.*;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.state.AbstractParserState;
import parser.state.ParserState;
import parser.state.impls.EmptyState;
import parser.state.impls.assignationStates.AssignationState;

@NoArgsConstructor
@AllArgsConstructor
public class TypeState extends AbstractParserState {

  private Token token;
  private TokenType tokenType;

  @Override
  public ParserState nextToken(Token t) {
    return switch (t.getTokenType()) {
      case ASSIGNATION -> new AssignationState(getDeclarationNode());
      case SEMICOLON -> {
        node = getDeclarationNode();
        yield new EmptyState();
      }
      default -> throw new IllegalStateException("Unexpected value: " + t.getTokenType());
    };
  }

  private DeclarationNode getDeclarationNode() {
    TypeValue typeValue =
        switch (tokenType) {
          case STRING_TYPE -> TypeValue.STRING;
          case NUMBER_TYPE -> TypeValue.NUMBER;
          default -> throw new IllegalStateException("Unexpected value: " + tokenType);
        };
    return new DeclarationNode(typeValue, new IdentifierNode(token.getValue()));
  }
}
