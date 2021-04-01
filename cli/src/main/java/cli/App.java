package cli;

import static picocli.CommandLine.*;

import fileReader.FileReaderPS;
import interpreter.InterpreterImpl;
import interpreter.ValidatorImpl;
import java.util.concurrent.Callable;
import lexer.LexerImpl;
import lombok.val;
import parser.ParserImpl;
import picocli.CommandLine;

@Command(
    name = "printscript",
    description = "Executes ps files",
    version = "0.1.0_alpha",
    mixinStandardHelpOptions = true)
public class App implements Callable<Integer> {

  @Option(names = "--validateOnly", description = "Validates the file.")
  boolean validateOnly;

  @Parameters(description = "File to execute.")
  String path;

  public static void main(String[] args) {
    final var exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);

    //      run("cli/src/main/resources/text.ps");
  }

  private void run() {
    val text = FileReaderPS.readFile(path);
    final var tokens = LexerImpl.lex(text);
    System.out.println("tokens = " + tokens);

    final var nodes = ParserImpl.parse(tokens);
    System.out.println(nodes);

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
