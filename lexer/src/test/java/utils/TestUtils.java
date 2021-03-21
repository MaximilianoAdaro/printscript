package utils;

import model.Position;
import model.Token;
import model.TokenType;
import state.context.LexerContext;
import state.impls.*;

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
        return Token.builder()
                .tokenType(tokenType)
                .value(value)
                .position(position)
                .build();
    }

    // create lexer context
    public static LexerContext clc(String acc, Position position) {
        return LexerContext.builder()
                .accumulator(acc)
                .position(position)
                .build();
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

}
