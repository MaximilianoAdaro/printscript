package lexer;

import lexer.config.TokenConfig;
import lexer.config.VersionsConfig;

public class LexerConfig {

  private static TokenConfig config = VersionsConfig.getLatest();

  public static void setConfig(TokenConfig tokenConfig) {
    config = tokenConfig;
  }

  public static TokenConfig getConfig() {
    return config;
  }
}
