package cli;

import static picocli.CommandLine.*;

import fileReader.FileReaderPS;
import interpreter.interpetation.InterpreterImpl;
import interpreter.validation.ValidatorImpl;
import java.io.File;
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
  private boolean validateOnly;

  @Parameters(description = "File to execute.", arity = "1")
  private File file;

  public static void main(String[] args) {
    final var exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }

  private void run() {
    val text = FileReaderPS.readFile(file);
    val tokens = LexerImpl.lex(text);
    val nodes = ParserImpl.parse(tokens);

    // here validates
    if (validateOnly) ValidatorImpl.run(nodes);
    else InterpreterImpl.run(nodes);

    //    ValidatorImpl.run(nodes);
    //    if (validateOnly) return;
    //    InterpreterImpl.run(nodes);
  }

  @Override
  public Integer call() {
    run();
    return 0;
  }
}
