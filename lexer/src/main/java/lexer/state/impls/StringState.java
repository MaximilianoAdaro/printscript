package lexer.state.impls;

import static lexer.exception.LexerException.illegalNewline;
import static lexer.exception.LexerException.illegalText;
import static lexer.utils.CharacterUtils.*;

import java.util.Optional;
import lexer.model.Token;
import lexer.model.TokenType;
import lexer.state.AbstractLexerState;
import lexer.state.LexerState;
import lexer.state.context.LexerContext;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class StringState extends AbstractLexerState {

  private final char startSymbol;
  private final boolean done;

  public StringState(LexerContext lexerContext, char startSymbol) {
    this(lexerContext, startSymbol, false);
  }

  public StringState(LexerContext lexerContext, char startSymbol, boolean done) {
    super(lexerContext);
    this.startSymbol = startSymbol;
    this.done = done;
  }

  @Override
  public LexerState nextValue(char c) {
    if (!done) {
      if (isNewline(c)) throw illegalNewline(c, lexerContext);
      if (isSameAsStart(c)) return new StringState(lexerContext.copy(), startSymbol, true);
      return new StringState(lexerContext.addCharacter(c), startSymbol);
    }

    // done
    if (isNewline(c)) return new EmptyState(lexerContext.changeLine());
    if (isWhitespace(c)) return new EmptyState(lexerContext.reset());
    if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));
    if (isNumber(c)) return new NumberState(lexerContext.reset(c));
    if (isLetter(c)) return new TextState(lexerContext.reset(c));

    throw illegalText(c, lexerContext);
  }

  @Override
  public Optional<Token> getToken() {
    return createToken(done, TokenType.STRING);
  }

  private boolean isSameAsStart(char c) {
    return c == startSymbol;
  }
}
