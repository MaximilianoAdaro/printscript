package model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Token {
    @NonNull
    private final TokenType tokenType;
    @NonNull
    private final String value;
    @NonNull
    private final Position position;

    public Token(@NonNull TokenType tokenType, @NonNull String value, @NonNull Position position) {
        this.tokenType = tokenType;
        this.value = value;
        this.position = position;
    }
}
