package interpreter.validation;

import lexer.LexerImpl;
import org.junit.Test;
import parser.ParserImpl;

public class ValidatorImplTest {

  @Test
  public void validatorTest() {
    final var text =
        """
                    let y: string = "El resultado es = ";
                    let y1: number = 0.1;
                    let y2: number = 0.01;
                    let y3: number = 102.7 + 123 * y1 * 10 - 15 / y2;
                    println(y + y3);
                    """;
    final var tokens = LexerImpl.lex(text);
    final var nodes = ParserImpl.parse(tokens);
    ValidatorImpl.run(nodes);
  }
}
