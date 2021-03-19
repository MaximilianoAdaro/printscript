package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Token {

    private final TokenType tokenType;
    private final String value;
    private final Position position;

}
