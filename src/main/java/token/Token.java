package token;

public interface Token {

    String getValue();

    TokenType getTokenEnum();

    int getLine();

}
