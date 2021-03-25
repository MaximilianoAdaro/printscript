package state.impls.declarationStates;

import model.Token;
import model.TokenType;
import node.impl.DeclarationNode;
import node.impl.IdentifierNode;
import node.impl.literalNodes.TypeValue;
import state.AbstractParserState;
import state.ParserState;
import state.impls.AssignationState;
import state.impls.EmptyState;

public class TypeState extends AbstractParserState {

    private final Token token;
    private final TokenType tokenType;

    public TypeState(Token token, TokenType tokenType) {
        this.token = token;
        this.tokenType = tokenType;
    }

    @Override
    public ParserState nextToken(Token t) {

        TypeValue typeValue = switch (tokenType) {
            case STRING_TYPE -> TypeValue.STRING;
            case NUMBER_TYPE -> TypeValue.NUMBER;
            default -> throw new IllegalStateException("Unexpected value: " + tokenType);
        };
        DeclarationNode declarationNode = new DeclarationNode(typeValue, new IdentifierNode(token.getValue()));

        return switch (t.getTokenType()) {
            case ASSIGNATION -> new AssignationState(declarationNode);
            case SEMICOLON -> {
                node = declarationNode;
                yield new EmptyState();
            }
            default -> throw new IllegalStateException("Unexpected value: " + t.getTokenType());
        };
    }

}
