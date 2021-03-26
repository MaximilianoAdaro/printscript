package lexer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class Position {

    private final int lineStart;
    private final int lineEnd;
    private final int columnStart;
    private final int columnEnd;

    public Position reset() {
        return Position.builder()
                .lineStart(lineStart)
                .lineEnd(lineEnd)
                .columnStart(columnEnd + 1)
                .columnEnd(columnEnd + 1)
                .build();
    }

    public Position newLine() {
        return Position.builder()
                .lineStart(lineStart + 1)
                .lineEnd(lineEnd + 1)
                .columnStart(0)
                .columnEnd(0)
                .build();
    }


    public Position advance() {
        return Position.builder()
                .lineStart(lineStart)
                .lineEnd(lineEnd)
                .columnStart(columnStart)
                .columnEnd(columnEnd + 1)
                .build();
    }

    public Position copy() {
        return Position.builder()
                .lineStart(lineStart)
                .lineEnd(lineEnd)
                .columnStart(columnStart)
                .columnEnd(columnEnd)
                .build();
    }
}
