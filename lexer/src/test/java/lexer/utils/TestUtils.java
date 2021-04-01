package lexer.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lexer.model.Position;
import lexer.model.Token;
import lexer.model.TokenType;
import lexer.state.context.LexerContext;
import lexer.state.impls.*;

public class TestUtils {

  // create position
  public static Position cp(int lineStart, int lineEnd, int columnStart, int columnEnd) {
    return Position.builder()
        .lineStart(lineStart)
        .lineEnd(lineEnd)
        .columnStart(columnStart)
        .columnEnd(columnEnd)
        .build();
  }

  // create token
  public static Token ct(String value, TokenType tokenType, Position position) {
    return Token.builder().tokenType(tokenType).value(value).position(position).build();
  }

  // create lexer context
  public static LexerContext clc(String acc, Position position) {
    return LexerContext.builder().accumulator(acc).position(position).build();
  }

  // create empty state
  public static EmptyState ces(LexerContext lexerContext) {
    return new EmptyState(lexerContext);
  }

  // create number state
  public static NumberState cns(LexerContext lexerContext) {
    return new NumberState(lexerContext);
  }

  // create string state
  public static StringState css(LexerContext lexerContext, char startSymbol, boolean done) {
    return new StringState(lexerContext, startSymbol, done);
  }

  // create symbol state
  public static SymbolState csys(LexerContext lexerContext) {
    return new SymbolState(lexerContext);
  }

  // create text state
  public static TextState cts(LexerContext lexerContext) {
    return new TextState(lexerContext);
  }

  public static List<Character> getSymbols() {
    return List.of('=', '+', '-', '*', '/', ':', ';');
  }

  public static List<Character> getWhitespace() {
    return List.of(' ', '\t');
  }

  public static List<Character> getStringSymbols() {
    return List.of('\'', '\"');
  }

  public static List<Character> getAllLetters() {
    return IntStream.concat(IntStream.rangeClosed('a', 'z'), IntStream.rangeClosed('A', 'Z'))
        .mapToObj(c -> (char) c)
        .collect(Collectors.toList());
  }

  public static List<Character> getNumbers() {
    return IntStream.rangeClosed('0', '9').mapToObj(c -> (char) c).collect(Collectors.toList());
  }

  public static List<Character> getAlphaNumeric() {
    return Stream.concat(getNumbers().stream(), getAllLetters().stream())
        .collect(Collectors.toList());
  }

  public static List<Character> getAllAsciiCharacters() {
    return IntStream.rangeClosed(0, 255).mapToObj(c -> (char) c).collect(Collectors.toList());
  }

  public static List<Character> getSymbolsNewlineAndWhitespace() {
    return Stream.concat(
            Stream.concat(getSymbols().stream(), Stream.of('\n')), getWhitespace().stream())
        .collect(Collectors.toList());
  }
}
