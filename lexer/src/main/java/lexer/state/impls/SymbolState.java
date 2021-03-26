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
public class SymbolState extends AbstractLexerState {

    public SymbolState(LexerContext lexerContext) {
        super(lexerContext);
    }

    @Override
    public LexerState nextValue(char c) {
        if (isNewline(c)) return new EmptyState(lexerContext.changeLine());
        if (isWhitespace(c)) return new EmptyState(lexerContext.reset());
        if (isNumber(c)) return new NumberState(lexerContext.reset(c));
        if (isAnySymbol(c)) return new SymbolState(lexerContext.reset(c));
        if (isStringSymbol(c)) return new StringState(lexerContext.reset(), c);
        if (isLetter(c)) return new TextState(lexerContext.reset(c));

        throw new IllegalStateException("Unexpected value: " + c);
    }

    @Override
    public Optional<Token> getToken() {
        final var c = lexerContext.getAccumulator();
        return switch (c) {
            case "*" -> createToken(TokenType.MULTIPLY);
            case "/" -> createToken(TokenType.DIVIDE);
            case "+" -> createToken(TokenType.PLUS);
            case "-" -> createToken(TokenType.MINUS);
            case "=" -> createToken(TokenType.ASSIGNATION);
            case ":" -> createToken(TokenType.COLON);
            case ";" -> createToken(TokenType.SEMICOLON);
            case "(" -> createToken(TokenType.LEFT_PAREN);
            case ")" -> createToken(TokenType.RIGHT_PAREN);

            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

}
