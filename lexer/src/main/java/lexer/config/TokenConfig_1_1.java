package lexer.config;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import static lexer.model.TokenType.*;

import java.util.Map;
import lexer.model.TokenType;

public class TokenConfig_1_1 implements TokenConfig {
  @Override
  public Map<String, TokenType> getKeywords() {
    return ofEntries(
        entry("let", LET),
        entry("const", CONST),
        entry("println", PRINT),
        entry("number", NUMBER_TYPE),
        entry("string", STRING_TYPE),
        entry("boolean", BOOLEAN_TYPE),
        entry("true", BOOLEAN),
        entry("false", BOOLEAN),
        entry("if", IF),
        entry("else", ELSE));
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
        entry(")", RIGHT_PAREN),
        entry("{", LEFT_CURLY_BRACES),
        entry("}", RIGHT_CURLY_BRACES),
        entry(">", GREATER),
        entry(">=", GREATER_EQUAL),
        entry("<", LESS),
        entry("<=", LESS_EQUAL));
  }
}
