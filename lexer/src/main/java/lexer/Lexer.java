package lexer;

import java.util.List;
import lexer.model.Token;

public interface Lexer {

  List<Token> createTokens(String text);
}
