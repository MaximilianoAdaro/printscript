package lexer.state;

import java.util.Optional;
import lexer.model.Token;

public interface LexerState {

  Optional<Token> getToken();

  LexerState nextValue(char c);
}
