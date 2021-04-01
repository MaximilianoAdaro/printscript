package lexer.state.impls;

import static lexer.utils.CharacterUtils.*;

import lexer.state.AbstractLexerState;
import lexer.state.LexerState;
import lexer.state.context.LexerContext;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
public class EmptyState extends AbstractLexerState {

  public EmptyState(LexerContext lexerContext) {
    super(lexerContext);
  }

  @Override
  public LexerState nextValue(char c) {
    if (isNewline(c)) return new EmptyState(lexerContext.changeLine());
    if (isWhitespace(c)) return new EmptyState(lexerContext.reset());
    if (isNumber(c)) return new NumberState(lexerContext.reset(c));
    if (isStringSymbol(c)) return new StringState(lexerContext.reset(), c);
    if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));
    if (isLetter(c)) return new TextState(lexerContext.reset(c));
    throw new IllegalStateException("Unexpected value: " + c);
  }
}
