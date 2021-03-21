package state.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Position;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LexerContext {

    @Builder.Default
    private final String accumulator = "";

    @Builder.Default
    private final Position position = new Position(1, 1, 0, 0);

    public LexerContext reset(Character c) {
        return createContext(c.toString());
    }

    public LexerContext reset() {
        return createContext("");
    }

    private LexerContext createContext(String acc) {
        return LexerContext.builder()
                .accumulator(acc)
                .position(position.reset())
                .build();
    }

    public LexerContext changeLine() {
        return LexerContext.builder()
                .accumulator("")
                .position(position.newLine())
                .build();
    }

    public LexerContext addCharacter(Character c) {
        return LexerContext.builder()
                .position(position.advance())
                .accumulator(accumulator + c)
                .build();
    }


}
