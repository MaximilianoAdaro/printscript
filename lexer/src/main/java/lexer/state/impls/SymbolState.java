package lexer.state.impls;

import static lexer.utils.CharacterUtils.*;

import java.util.List;
import java.util.Optional;
import lexer.LexerConfig;
import lexer.exception.LexerException;
import lexer.model.Token;
import lexer.state.AbstractLexerState;
import lexer.state.LexerState;
import lexer.state.context.LexerContext;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
public class SymbolState extends AbstractLexerState {

  private boolean done = false;

  public SymbolState(LexerContext lexerContext) {
    super(lexerContext);
  }

  @Override
  public LexerState nextValue(char c) {

    if (List.of("<", ">").contains(lexerContext.getAccumulator())) {
      if (isEqual(c)) return new SymbolState(lexerContext.addCharacter(c));
    }

    //    Lexer.config.getSymbols()

    done = true;
    if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));
    if (isSemicolon(c)) return new SymbolState(lexerContext.reset(c));
    if (isNewline(c)) return new EmptyState(lexerContext.changeLine());
    if (isWhitespace(c)) return new EmptyState(lexerContext.reset());
    if (isNumber(c)) return new NumberState(lexerContext.reset(c));
    if (isStringSymbol(c)) return new StringState(lexerContext.reset(), c);
    if (isLetter(c)) return new TextState(lexerContext.reset(c));

    throw LexerException.illegalText(c, lexerContext);
  }

  @Override
  public Optional<Token> getToken() {
    if (!done) return Optional.empty();

    final var c = lexerContext.getAccumulator();
    final var symbols = LexerConfig.getConfig().getSymbols();

    final var tokenType =
        Optional.ofNullable(symbols.get(c))
            .orElseThrow(() -> LexerException.illegalText(' ', lexerContext));

    return createToken(tokenType);
  }
}
