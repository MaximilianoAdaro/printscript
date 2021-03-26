package parser.state.impls;

import lexer.model.Token;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import parser.state.AbstractParserState;
import parser.state.ParserState;
import parser.state.impls.declarationStates.DeclarationState;
import parser.state.impls.printStates.PrintState;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
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
