package parserTest;

import lexer.LexerImpl;
import org.junit.Test;
import parser.ParserImpl;

public class ParserImplTest {

    @Test
    public void test() {

        String text = """
                let x: string = "hello world";
                println(x);""";
        final var tokens = LexerImpl.lex(text);
        final var nodes = ParserImpl.parse(tokens);
        System.out.println(nodes);
    }

}