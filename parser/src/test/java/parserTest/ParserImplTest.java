package parserTest;

import fileReader.FileReaderPS;
import lexer.LexerImpl;
import org.junit.Test;
import parser.ParserImpl;

import java.io.FileNotFoundException;

public class ParserImplTest {

    @Test
    public void test() throws FileNotFoundException {

        String path = "/home/maxi/projects/ing-sist/printscript/app/src/main/resources/text.ps";
        String text = FileReaderPS.readFile(path);
        final var tokens = LexerImpl.lex(text);
        final var nodes = ParserImpl.parse(tokens);
        System.out.println(nodes);
    }

}