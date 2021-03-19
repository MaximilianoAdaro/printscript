import lombok.Data;
import lombok.NonNull;
import model.Token;
import state.LexerState;
import state.impls.EmptyState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class LexerImpl implements Lexer {

    @NonNull
    private final List<Token> tokens = new ArrayList<>();
    @NonNull
    private LexerState state = new EmptyState();

    @Override
    public @NonNull List<Token> createTokens(@NonNull String text) {
        final var characterStream = getCharacterStream(text);

        characterStream.forEach(this::consumeCharacter);

        return tokens;
    }

    private Stream<Character> getCharacterStream(String text) {
        return text.chars().mapToObj(c -> (char) c);
    }


    private void consumeCharacter(Character c) {
        final var nextState = state.nextValue(c);
        state.getToken().ifPresent(tokens::add);
        state = nextState;
    }
}
