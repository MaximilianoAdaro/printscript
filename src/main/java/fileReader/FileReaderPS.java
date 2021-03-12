package fileReader;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
public class FileReaderPS {

    public String readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return br.lines().collect(Collectors.joining("\n"));

    }
}
