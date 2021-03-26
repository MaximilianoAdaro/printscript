package parserTest;

import lexer.LexerImpl;
import lombok.val;
import org.junit.Test;
import parser.ParserImpl;

public class ParserImplTest {

    @Test
    public void test() {

        val text = """
                let x: string = "hello world";
                let y: number = 18.3;
                println(x + y);
                """;
        final var tokens = LexerImpl.lex(text);
        final var nodes = ParserImpl.parse(tokens);
        nodes.forEach(System.out::println);
    }

}