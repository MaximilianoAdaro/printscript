package lexer;

import lexer.model.Token;

import java.util.List;

public interface Lexer {

    List<Token> createTokens(String text);
}
