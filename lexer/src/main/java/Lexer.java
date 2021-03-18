import lombok.NonNull;
import model.Token;

import java.util.List;

public interface Lexer {

    @NonNull List<Token> createTokens(@NonNull String text);
}
