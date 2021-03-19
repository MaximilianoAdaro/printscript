package state.context;

import lombok.Data;
import model.Position;

@Data
public class LexerContext {

    private String accumulator = "";
    private final Position position = new Position(0, 0, 0, 0);

    void reset() {
        accumulator = "";
//        position.
    }

    void changeLine() {
//        position
    }

    void addCharater(Character c) {
        accumulator += c;
    }


}
