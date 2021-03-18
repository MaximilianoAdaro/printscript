package state.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import model.Position;

@Data
@AllArgsConstructor
public class LexerContext {

    @NonNull
    private final String accumulator = "";

    @NonNull
    private final Position position = new Position(0, 0, 0, 0);
}
