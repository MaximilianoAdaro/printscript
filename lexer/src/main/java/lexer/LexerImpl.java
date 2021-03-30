package lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lexer.model.Token;
import lexer.state.LexerState;
import lexer.state.context.LexerContext;
import lexer.state.impls.EmptyState;

public class LexerImpl implements Lexer {

  private final List<Token> tokens = new ArrayList<>();
  private LexerState state = new EmptyState(new LexerContext());

  public static List<Token> lex(String text) {
    return new LexerImpl().createTokens(text);
  }

  @Override
  public List<Token> createTokens(String text) {
    getCharacterStream(text).forEach(this::consumeCharacter);
    consumeCharacter(' '); // last character, end of file
    return tokens;
  }

  private void consumeCharacter
















          (Character c) {
    final var nextState = state.nextValue(c);
    state.getToken().ifPresent(tokens::add);
    state = nextState;
  }

  private Stream<Character> getCharacterStream(String text) {
    return text.chars().mapToObj(c -> (char) c);
  }
}
