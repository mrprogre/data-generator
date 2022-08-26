package util;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FileWriter {

    public void save(List<String> list) throws IOException {
        Writer fileWriter = new java.io.FileWriter("test.csv", false);
        fileWriter.write("header1;header2;header3;header4\n");

        list.forEach(x -> {
            try {
                fileWriter.write(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        fileWriter.close();
    }
}