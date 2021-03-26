package lexer.state.impls;

import lexer.model.Token;
import lexer.model.TokenType;
import lexer.state.AbstractLexerState;
import lexer.state.LexerState;
import lexer.state.context.LexerContext;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Optional;

import static lexer.utils.CharacterUtils.*;

@ToString
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
            if (isSameAsStart(c)) return new StringState(lexerContext.addCharacter(c), startSymbol, true);
            if (isNewline(c)) throw new IllegalStateException();
            return new StringState(lexerContext.addCharacter(c), startSymbol);
        }

        // done
        if (isNewline(c)) return new EmptyState(lexerContext.changeLine());
        if (isWhitespace(c)) return new EmptyState(lexerContext.reset());
        if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));
        if (isNumber(c)) return new NumberState(lexerContext.reset(c));
        if (isLetter(c)) return new TextState(lexerContext.reset(c));

        throw new IllegalStateException("Unexpected value: " + c);
    }

    @Override
    public Optional<Token> getToken() {
        return createToken(done, TokenType.STRING);
    }

    private boolean isSameAsStart(char c) {
        return c == startSymbol;
    }
}
