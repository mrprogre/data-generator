package com.avandy.dataset.util;

import com.avandy.dataset.ui.Gui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class Saver {
    public void saveCsv(List<String> list, String path) throws IOException {
        Writer fileWriter = new FileWriter(path, false);
        // Заголовки
        fileWriter.write(Arrays.toString(Gui.MAIN_TABLE_HEADERS) + "\n");

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