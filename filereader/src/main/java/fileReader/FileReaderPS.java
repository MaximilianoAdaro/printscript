package fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.stream.Collectors;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
public class FileReaderPS {

  @SneakyThrows
  public static String readFile(String filePath) {
    val br = new BufferedReader(new FileReader(filePath));
    return br.lines().collect(Collectors.joining("\n"));
  }

  @SneakyThrows
  public static String readFile(File file) {
    val br = new BufferedReader(new FileReader(file));
    return br.lines().collect(Collectors.joining("\n"));
  }

  @SneakyThrows
  public static String readFile(Path path) {
    final var file = path.toFile();
    return readFile(file);
  }
}
