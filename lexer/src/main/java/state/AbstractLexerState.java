package state;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Token;
import state.context.LexerContext;

import java.util.Optional;

@Data
@AllArgsConstructor
public abstract class AbstractLexerState implements LexerState {

    protected final LexerContext lexerContext = new LexerContext();


    @Override
    public Optional<Token> getToken() {
        return Optional.empty();
    }

    @Override
    public LexerState nextValue(char c) {
        return null;
    }

}
