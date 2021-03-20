package state.impls;

import model.Token;
import model.TokenType;
import state.AbstractLexerState;
import state.LexerState;
import state.context.LexerContext;

import java.util.Optional;

import static utils.CharacterUtils.*;


public class SymbolState extends AbstractLexerState {

    public SymbolState(LexerContext lexerContext) {
        super(lexerContext);
    }

    @Override
    public LexerState nextValue(char c) {
        if (isWhitespace(c)) return new EmptyState(lexerContext.reset());
        if (isNumber(c)) return new NumberState(lexerContext.reset(c));
        if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));

        throw new IllegalStateException("Unexpected value: " + c);
    }

    @Override
    public Optional<Token> getToken() {
        final var c = lexerContext.getAccumulator();
        return switch (c) {
            case "*" -> createToken(TokenType.MULTIPLY);
            case "/" -> createToken(TokenType.DIVIDE);
            case "+" -> createToken(TokenType.PLUS);
            case "-" -> createToken(TokenType.MINUS);
            case "=" -> createToken(TokenType.ASSIGNATION);
            case ":" -> createToken(TokenType.COLON);
            case ";" -> createToken(TokenType.SEMICOLON);

            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

}
