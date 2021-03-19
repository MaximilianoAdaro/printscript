package state.impls;

import model.Token;
import model.TokenType;
import state.AbstractLexerState;
import state.LexerState;
import state.context.LexerContext;

import java.util.Optional;

public class NumberState extends AbstractLexerState {

    private boolean done = false;

    public NumberState(LexerContext reset) {
        super(reset);
    }

    @Override
    public LexerState nextValue(char c) {
        if (isNumber(c)) {
            lexerContext.addCharacter(c);
            return this;
        }
        if (isMathSymbol(c)) {
            done = true;
            return new SymbolState(lexerContext.reset(c));
        }
        if (isBlank(c)) {
            done = true;
            return new EmptyState(lexerContext.reset());
        }

        if (isSemicolon(c)) {
            done = true;
            return new SymbolState(lexerContext.reset(c));
        }


        throw new IllegalStateException("Unexpected value: " + c);

    }

    @Override
    public Optional<Token> getToken() {
        return getToken(done, TokenType.NUMBER);
    }
}
