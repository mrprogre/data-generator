package com.avandy.dataset.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Saver {

    public void saveCsv(List<String> list, String path) throws IOException {
        Writer fileWriter = new FileWriter(path, false);
        //fileWriter.write("id;name;age;avg_grade;\n");

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