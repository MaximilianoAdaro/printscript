package interpreter.interpetation;

import interpreter.validation.ValidatorImpl;
import lexer.LexerImpl;
import org.junit.Test;
import parser.ParserImpl;

public class InterpreterImplTest {

  @Test
  public void xx() {
    final var text =
        """
            let x: string = "El resultado es = ";
            let qwe: number = 0.1;
            let inf: number = 0.01;
            let num: number = 102.7 + 123 * qwe * 10 - 15 / inf;
            println(x + num);
            """;
    final var tokens = LexerImpl.lex(text);
    final var nodes = ParserImpl.parse(tokens);

    ValidatorImpl.run(nodes);
    //    InterpreterImpl.run(nodes);
  }
}
