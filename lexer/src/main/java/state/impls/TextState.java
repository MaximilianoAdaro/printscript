package state.impls;

import model.Token;
import model.TokenType;
import state.AbstractLexerState;
import state.LexerState;
import state.context.LexerContext;

import java.util.Optional;

import static utils.CharacterUtils.*;


public class TextState extends AbstractLexerState {

    private boolean done;

    public TextState(LexerContext lexerContext) {
        super(lexerContext);
    }


    @Override
    public LexerState nextValue(char c) {
        if (isNewline(c)) {
            done = true;
            return new EmptyState(lexerContext.changeLine());
        }
        if (isWhitespace(c)) {
            done = true;
            return new EmptyState(lexerContext.reset());
        }
        if (isAnySymbol(c)) {
            done = true;
            return new SymbolState(lexerContext.reset(c));
        }
        if (isLetter(c) || isNumber(c)) return new TextState(lexerContext.addCharacter(c));

        throw new IllegalStateException("Unexpected value: " + c);
    }

    @Override
    public Optional<Token> getToken() {
        if (!done) return Optional.empty();

        final var accumulator = lexerContext.getAccumulator();

        return switch (accumulator) {
            case "let" -> createToken(TokenType.LET);
            case "println" -> createToken(TokenType.PRINT);
            default -> createToken(TokenType.IDENTIFIER);
        };

    }

}
