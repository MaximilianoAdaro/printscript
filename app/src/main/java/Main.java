import fileReader.FileReaderPS;
import lexer.LexerImpl;
import lombok.SneakyThrows;
import parser.ParserImpl;

public class Main {


    public static void main(String[] args) {

        run("/home/joacoiannuzzi/dev/printscript/app/src/main/resources/text.ps");

    }

    @SneakyThrows
    static void run(final String path) {
        String text = FileReaderPS.readFile(path);
        final var tokens = LexerImpl.lex(text);
        final var nodes = ParserImpl.parse(tokens);
        System.out.println(nodes);
    }
}
