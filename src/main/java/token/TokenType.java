package token;

public enum TokenType {

    // Single-character tokens.
    SEMICOLON,
    COLON,
    ASSIGNATION,

    // Operations
    MINUS,
    PLUS,
    MULTIPLY,
    DIVIDE,

    // Literals.
    IDENTIFIER,
    STRING,
    NUMBER,
    BOOLEAN,

    // Keywords.
    PRINT,
    LET,

    INVALID
}
