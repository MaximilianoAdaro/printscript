package state;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import model.Token;
import state.context.LexerContext;

import java.util.Optional;

@Data
@AllArgsConstructor
public abstract class AbstractLexerState implements LexerState {

    @NonNull
    private final LexerContext lexerContext = new LexerContext();


    @Override
    public @NonNull Optional<Token> getToken() {
        return Optional.empty();
    }

    @Override
    public @NonNull LexerState nextValue(@NonNull char c) {
        return null;
    }
}
