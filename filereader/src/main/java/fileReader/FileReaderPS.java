package fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class FileReaderPS {

  public static String readFile(File file) {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    assert br != null;
    return br.lines().collect(Collectors.joining("\n"));
  }
}
