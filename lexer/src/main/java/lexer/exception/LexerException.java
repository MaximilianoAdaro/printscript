package lexer.exception;

import lexer.state.context.LexerContext;

public class LexerException extends RuntimeException {

  public LexerException(String message) {
    super(message);
  }

  public static LexerException unidentifiedCharacter(char c, LexerContext context) {
    final var position = context.getPosition();
    return new LexerException(
        "Unexpected value"
            + " at line: "
            + position.getLineStart()
            + "and column: "
            + position.getColumnStart()
            + " -> "
            + c);
  }

  public static LexerException illegalText(char c, LexerContext context) {
    final var position = context.getPosition();
    final var accumulator = context.getAccumulator();
    return new LexerException(
        "Unexpected text"
            + " at line: "
            + position.getLineStart()
            + " between columns: ( "
            + position.getColumnStart()
            + ", "
            + position.getColumnEnd()
            + " ) -> "
            + accumulator
            + c);
  }

  public static LexerException illegalNewline(char c, LexerContext context) {
    final var position = context.getPosition();
    final var accumulator = context.getAccumulator();
    return new LexerException(
        "Unclosed string"
            + " at line: "
            + position.getLineStart()
            + " between columns: ( "
            + position.getColumnStart()
            + ", "
            + position.getColumnEnd()
            + " ) -> "
            + accumulator);
  }
}
