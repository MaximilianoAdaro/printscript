package state.impls;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Token;
import state.AbstractParserState;
import state.ParserState;
import state.impls.declarationStates.DeclarationState;
import state.impls.printStates.PrintState;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmptyState extends AbstractParserState {
    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case LET -> new DeclarationState();
            case IDENTIFIER -> new IdentifierAssignationState();
            case PRINT -> new PrintState();
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }
}