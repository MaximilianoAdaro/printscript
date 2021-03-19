package state.impls;

import model.Token;
import model.TokenType;
import state.AbstractLexerState;
import state.LexerState;
import state.context.LexerContext;

import java.util.Optional;


public class StringState extends AbstractLexerState {

    private final char startSymbol;
    private boolean done = false;

    public StringState(LexerContext lexerContext, char startSymbol) {
        super(lexerContext);
        this.startSymbol = startSymbol;
    }

    @Override
    public LexerState nextValue(char c) {
        if (isSameAsStart(c)) {
            done = true;
            return new EmptyState(lexerContext.reset());
        }
        lexerContext.addCharacter(c);
        return this;

    }

    @Override
    public Optional<Token> getToken() {
        return getToken(done, TokenType.STRING);
    }

    private boolean isSameAsStart(char c) {
        return c == startSymbol;
    }
}
