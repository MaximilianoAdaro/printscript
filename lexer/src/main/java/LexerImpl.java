import lombok.Data;
import lombok.NonNull;
import model.Token;
import state.LexerState;
import state.impls.EmptyState;

import java.util.Collections;
import java.util.List;

@Data
public class LexerImpl implements Lexer {

    @NonNull
    private final LexerState state = new EmptyState();
    @NonNull
    private final List<Token> tokens = Collections.emptyList();

    @Override
    public @NonNull List<Token> createTokens(@NonNull String text) {
        return null;
    }
}
