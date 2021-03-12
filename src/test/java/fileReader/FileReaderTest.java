package fileReader;

import org.junit.Test;

public class FileReaderTest {

    @Test
    public void testFileReader() throws Exception {
        final String path = "/home/maxi/projects/ing-sist/PrintScript-1.0/src/test/resources/text.ps";
        FileReaderPS fileReaderPS = new FileReaderPS();
        String file = fileReaderPS.readFile(path);
        System.out.println(file);

    }

}
