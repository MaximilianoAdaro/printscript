package state.impls;

import state.AbstractLexerState;
import state.LexerState;
import state.context.LexerContext;


public class EmptyState extends AbstractLexerState {


    public EmptyState(LexerContext lexerContext) {
        super(lexerContext);
    }

    @Override
    public LexerState nextValue(char c) {
        if (isBlank(c)) return this;
        if (isNumber(c)) return new NumberState(lexerContext.reset(c));
        if (isStringSymbol(c)) return new StringState(lexerContext, c);
        if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));
        throw new IllegalStateException("Unexpected value: " + c);
    }
}
