package state.impls;

import lombok.NonNull;
import state.AbstractLexerState;
import state.LexerState;
import state.context.LexerContext;


public class TextState extends AbstractLexerState {
    public TextState(LexerContext lexerContext) {
        super(lexerContext);
    }

    @Override
    public @NonNull LexerState nextValue(@NonNull char c) {
        return null;
    }
}
