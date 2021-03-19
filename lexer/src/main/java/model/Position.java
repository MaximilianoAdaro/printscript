package model;

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
}
