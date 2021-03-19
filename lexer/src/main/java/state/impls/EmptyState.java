package state.impls;

import lombok.Data;
import state.AbstractLexerState;
import state.LexerState;

@Data
public class EmptyState extends AbstractLexerState {


    @Override
    public LexerState nextValue(char c) {
        lexerContext.getAccumulator();
        return super.nextValue(c);
    }
}
