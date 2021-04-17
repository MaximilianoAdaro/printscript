package lexer.config;

import java.util.Map;
import lexer.model.TokenType;

public interface TokenConfig {

  Map<String, TokenType> getKeywords();

  Map<String, TokenType> getSymbols();
}
