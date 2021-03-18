package state;

import lombok.NonNull;
import model.Token;

import java.util.Optional;

public interface LexerState {

    @NonNull Optional<Token> getToken();

    @NonNull LexerState nextValue(@NonNull char c);
}
