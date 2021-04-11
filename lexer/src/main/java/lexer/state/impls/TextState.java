package lexer.state.impls;

import static lexer.utils.CharacterUtils.*;

import java.util.Optional;
import lexer.exception.LexerException;
import lexer.model.Token;
import lexer.model.TokenType;
import lexer.state.AbstractLexerState;
import lexer.state.LexerState;
import lexer.state.context.LexerContext;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
public class TextState extends AbstractLexerState {

  private boolean done;

  public TextState(LexerContext lexerContext) {
    super(lexerContext);
  }

  @Override
  public LexerState nextValue(char c) {
    if (isLetter(c) || isNumber(c)) return new TextState(lexerContext.addCharacter(c));

    done = true;
    if (isNewline(c)) return new EmptyState(lexerContext.changeLine());

    if (isWhitespace(c)) return new EmptyState(lexerContext.reset());
    if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));

    throw LexerException.illegalText(c, lexerContext);
  }

  @Override
  public Optional<Token> getToken() {
    if (!done) return Optional.empty();

    final var accumulator = lexerContext.getAccumulator();

    return switch (accumulator) {
      case "let" -> createToken(TokenType.LET);
      case "const" -> createToken(TokenType.CONST);
      case "println" -> createToken(TokenType.PRINT);
      case "number" -> createToken(TokenType.NUMBER_TYPE);
      case "string" -> createToken(TokenType.STRING_TYPE);
      default -> createToken(TokenType.IDENTIFIER);
    };
  }
}
