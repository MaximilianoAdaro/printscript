package state.context;

import lombok.Data;
import lombok.NonNull;
import model.Position;

@Data
public class LexerContext {

    @NonNull
    private final String accumulator = "";

    @NonNull
    private final Position position = new Position(0, 0, 0, 0);
}
