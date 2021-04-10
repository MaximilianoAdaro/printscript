package parser.exception;

import lexer.model.Token;

public class ParserException extends RuntimeException {

  private ParserException(String message) {
    super(message);
  }

  public static ParserException unexpectedToken(Token token) {
    final var position = token.getPosition();
    return position.getColumnStart() == position.getColumnEnd()
        ? new ParserException(
            "Unexpected value "
                + "at line "
                + position.getLineStart()
                + " and column "
                + position.getColumnStart()
                + " -> "
                + token.getValue())
        : new ParserException(
            "Unexpected value "
                + "at line "
                + position.getLineStart()
                + " between columns ( "
                + position.getColumnStart()
                + ", "
                + position.getColumnEnd()
                + " ) -> "
                + token.getValue());
  }
}
