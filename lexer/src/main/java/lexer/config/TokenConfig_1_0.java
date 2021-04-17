package lexer.config;

import static java.util.Map.*;
import static lexer.model.TokenType.*;

import java.util.Map;
import lexer.model.TokenType;

public class TokenConfig_1_0 implements TokenConfig {

  @Override
  public Map<String, TokenType> getKeywords() {
    return ofEntries(
        entry("let", LET),
        entry("println", PRINT),
        entry("number", NUMBER_TYPE),
        entry("string", STRING_TYPE));
  }

  @Override
  public Map<String, TokenType> getSymbols() {
    return ofEntries(
        entry("*", MULTIPLY),
        entry("/", DIVIDE),
        entry("+", PLUS),
        entry("-", MINUS),
        entry("=", ASSIGNATION),
        entry(":", COLON),
        entry(";", SEMICOLON),
        entry("(", LEFT_PAREN),
        entry(")", RIGHT_PAREN));
  }
}
