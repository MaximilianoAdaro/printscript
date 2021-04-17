package lexer.config;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

import java.util.Map;

public class VersionsConfig {

  private static final Map<String, TokenConfig> configs =
      ofEntries(entry("1.0", new TokenConfig_1_0()), entry("1.1", new TokenConfig_1_1()));

  public static TokenConfig getConfig(String version) {
    if (!configs.containsKey(version)) throw new RuntimeException("Invalid version");
    return configs.get(version);
  }

  public static TokenConfig getLatest() {
    return configs.get("1.1");
  }
}
