package com.avandy.dataset.util;

import com.avandy.dataset.ui.Gui;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Saver {

    public void exportData(JFileChooser saver) throws IOException {
        long start = System.currentTimeMillis();
        Writer fileWriter = new FileWriter(saver.getSelectedFile() + "." + Gui.saveFormatComboBox.getSelectedItem(), false);
        fileWriter.write(String.join(";", Gui.MAIN_TABLE_HEADERS) + "\n");

        for (int i = 0; i < Gui.model.getRowCount(); i++) {
            for (int j = 0; j < Gui.model.getColumnCount(); j++) {
                fileWriter.write(Gui.model.getValueAt(i, j) + ";");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
        Gui.setStatus("Export completed in " + (System.currentTimeMillis() - start) + " ms.");
    }

}