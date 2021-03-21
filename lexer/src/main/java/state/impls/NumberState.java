package state.impls;

import model.Token;
import model.TokenType;
import state.AbstractLexerState;
import state.LexerState;
import state.context.LexerContext;

import java.util.Optional;

import static utils.CharacterUtils.*;

public class NumberState extends AbstractLexerState {

    private boolean done = false;

    public NumberState(LexerContext reset) {
        super(reset);
    }

    @Override
    public LexerState nextValue(char c) {
        if (isNumber(c)) return new NumberState(lexerContext.addCharacter(c));

        if (isAnySymbol(c)) {
            done = true;
            return new SymbolState(lexerContext.reset(c));
        }

        if (isNewline(c)) {
            done = true;
            return new EmptyState(lexerContext.changeLine());
        }
        if (isWhitespace(c)) {
            done = true;
            return new EmptyState(lexerContext.reset());
        }

        throw new IllegalStateException("Unexpected value: " + c);

    }

    @Override
    public Optional<Token> getToken() {
        return createToken(done, TokenType.NUMBER);
    }
}
