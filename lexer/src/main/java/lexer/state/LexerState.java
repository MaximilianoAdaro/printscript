package lexer.state;

import lexer.model.Token;

import java.util.Optional;

public interface LexerState {

    Optional<Token> getToken();

    LexerState nextValue(char c);
}
