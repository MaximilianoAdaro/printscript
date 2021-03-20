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
    private String accumulator = "";

    @Builder.Default
    private final Position position = new Position(0, 0, 0, 0);

    public LexerContext reset(Character c) {
        return LexerContext.builder()
                .position(position)
                .accumulator(c.toString())
                .build();


    }

    public LexerContext reset() {
        return LexerContext.builder()
                .accumulator("")
                .position(position)
                .build();
    }

    public void changeLine() {
//        position
    }

    public LexerContext addCharacter(Character c) {
        return LexerContext.builder()
                .position(position)
                .accumulator(accumulator + c)
                .build();
    }


}
