package cli;

import static picocli.CommandLine.*;

import edu.austral.ingsis.Lexer;
import edu.austral.ingsis.LexerImpl;
import fileReader.FileReaderPS;
import interpreter.Interpreter;
import java.io.File;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import lexer.config.VersionsConfig;
import lombok.val;
import parser.Parser;
import picocli.CommandLine;

@Command(
    name = "printscript",
    description = "Executes ps files",
    version = "1.1.4",
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
    val tokens =
        lexer.Lexer.lex(text, VersionsConfig.getConfig(Optional.ofNullable(version).orElse("1.1")));
    val nodes = Parser.parse(tokens);

    if (validateOnly) Interpreter.run(nodes, __ -> {});
    else Interpreter.run(nodes, System.out::println);
  }

  public static void run(File file, String version, Consumer<String> stdOut) {
    val text = FileReaderPS.readFile(file);
    val tokens =
        lexer.Lexer.lex(text, VersionsConfig.getConfig(Optional.ofNullable(version).orElse("1.1")));
    val nodes = Parser.parse(tokens);
    Interpreter.run(nodes, stdOut);
  }

  private void runIntegration() {
    Lexer lexer = new LexerImpl();
    //    lexer.analyseLexically();
  }

  @Override
  public Integer call() {
    run();
    return 0;
  }
}
