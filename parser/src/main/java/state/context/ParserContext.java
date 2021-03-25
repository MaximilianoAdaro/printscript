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
public class ParserContext {

    @Builder.Default
    private final String accumulator = "";

    @Builder.Default
    private final Position position = new Position(1, 1, 0, 0);

    public ParserContext reset(Character c) {
        return createContext(c.toString());
    }

    public ParserContext reset() {
        return createContext("");
    }

    private ParserContext createContext(String acc) {
        return ParserContext.builder()
                .accumulator(acc)
                .position(position.reset())
                .build();
    }

    public ParserContext changeLine() {
        return ParserContext.builder()
                .accumulator("")
                .position(position.newLine())
                .build();
    }

    public ParserContext addCharacter(Character c) {
        return ParserContext.builder()
                .position(position.advance())
                .accumulator(accumulator + c)
                .build();
    }


}
