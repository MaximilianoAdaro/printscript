package cli;

import interpreter.InterpreterImpl;
import interpreter.ValidatorImpl;
import lexer.LexerImpl;
import lombok.val;
import parser.ParserImpl;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

import static picocli.CommandLine.*;

@Command(
    name = "printscript",
    description = "Executes ps files",
    version = "0.1.0_alpha",
    mixinStandardHelpOptions = true)
public class App implements Callable<Integer> {

  @Option(names = "--validateOnly", description = "Validates the file.")
  private boolean validateOnly;

  @Parameters(description = "File to execute.", arity = "1")
  private File file;

  public static void main(String[] args) {
    final var exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }

  private void run() {
    val text = FileReadePS.readFile(file);
    val tokens = LexerImpl.lex(text);
    //    System.out.println("tokens = " + tokens);

    val nodes = ParserImpl.parse(tokens);
    nodes.forEach(System.out::println);

    // here validates
    ValidatorImpl.run(nodes);
    if (validateOnly) return;

    InterpreterImpl.run(nodes);
  }

  @Override
  public Integer call() {
    run();
    return 0;
  }
}
