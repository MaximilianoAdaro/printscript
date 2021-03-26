package parser.state.impls.printStates;

import lexer.model.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.state.AbstractParserState;
import parser.state.ParserState;

import java.util.List;

import static parser.state.util.StateUtils.addToList;

@EqualsAndHashCode(callSuper = true)
@Data
public class OperandPrintState extends AbstractParserState {

    private final List<Token> tokens;

    public OperandPrintState(Token token, List<Token> tokens) {
        this.tokens = addToList(tokens, token);
    }

    @Override
    public ParserState nextToken(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifiedPrintState(token, tokens);
            case NUMBER, STRING -> new ValuePrintState(token, tokens);
            default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
        };
    }
}
