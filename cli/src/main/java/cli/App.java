package cli;

import static picocli.CommandLine.*;

import fileReader.FileReaderPS;
import interpreter.Interpreter;
import java.io.File;
import java.util.concurrent.Callable;
import lexer.Lexer;
import lexer.config.VersionsConfig;
import lombok.val;
import parser.Parser;
import picocli.CommandLine;

@Command(
    name = "printscript",
    description = "Executes ps files",
    version = "1.1",
    mixinStandardHelpOptions = true)
public class App implements Callable<Integer> {

  @Option(names = "--validateOnly", description = "Validates the file only.")
  private boolean validateOnly;

  @Option(names = "--use", description = "Interprets the file according to this version")
  private String version;

  @Parameters(description = "File to execute.", arity = "1")
  private File file;

  public static void main(String[] args) {
    final var exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }

  private void run() {
    val text = FileReaderPS.readFile(file);
    val tokens = Lexer.lex(text, VersionsConfig.getConfig(version));
    val nodes = Parser.parse(tokens);

    if (validateOnly) Interpreter.run(nodes, __ -> {});
    else Interpreter.run(nodes, System.out::println);
  }

  @Override
  public Integer call() {
    run();
    return 0;
  }
}
