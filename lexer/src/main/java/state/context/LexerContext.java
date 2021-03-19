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
    private final Position position = new Position(0, 0, 0, 0);

    public LexerContext reset(Character c) {
        accumulator = c.toString();
        return this;

    }

    public LexerContext reset() {
        accumulator = "";
        return this;
    }

    void changeLine() {
//        position
    }

    public LexerContext addCharacter(Character c) {
        accumulator += c.toString();
        return this;
    }


}
