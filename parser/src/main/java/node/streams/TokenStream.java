package node.streams;

import model.Token;

public interface TokenStream {

    Token peek();

    Token peekAdvance();

    void advance();

    boolean hasNext();
}
