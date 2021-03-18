package model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Position {
    @NonNull
    private final int lineStart;
    @NonNull
    private final int lineEnd;
    @NonNull
    private final int columnStart;
    @NonNull
    private final int columnEnd;

    public Position(@NonNull int lineStart, @NonNull int lineEnd, @NonNull int columnStart, @NonNull int columnEnd) {
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
    }
}
