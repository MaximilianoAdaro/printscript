package lexer.state.impls;

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
public class NumberState extends AbstractLexerState {

  private boolean done = false;
  private final boolean isDecimal;

  public NumberState(LexerContext context) {
    this(context, false);
  }

  public NumberState(LexerContext context, boolean isDecimal) {
    super(context);
    this.isDecimal = isDecimal;
  }

  @Override
  public LexerState nextValue(char c) {
    if (isNumber(c)) return new NumberState(lexerContext.addCharacter(c), isDecimal);

    if (isDot(c)) {
      if (!isDecimal) return new NumberState(lexerContext.addCharacter(c), true);
      throw illegalText(c, lexerContext);
    }
    done = true;
    if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));
    if (isNewline(c)) return new EmptyState(lexerContext.changeLine());
    if (isWhitespace(c)) return new EmptyState(lexerContext.reset());

    throw illegalText(c, lexerContext);
  }

  @Override
  public Optional<Token> getToken() {
    return createToken(done, TokenType.NUMBER);
  }
}
