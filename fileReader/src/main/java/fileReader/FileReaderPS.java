package fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
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
}
