package com.avandy.dataset.generator;

import com.avandy.dataset.list.Lists;
import com.avandy.dataset.ui.Gui;
import com.avandy.dataset.util.FileWriter;
import com.avandy.dataset.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private final Lists lists;

    public Generator() {
        this.lists = new Lists();
    }

    public void generate() {
        generateRows(Gui.rowsCount.getText());
    }

    private void generateRows(String rowsCount) {
        //int firstParam = Integer.parseInt(args[0]);
        int rowsToGenerate = Integer.parseInt(rowsCount);
        final int minAge = 18;
        final int maxAge = 50;
        final int minGrade = 2;
        final int maxGrade = 5;
        List<String> rows = new ArrayList<>();

        String row;
        String rowFormat = "%d;%d;%s;%d;%s;";

        if (Gui.model.getRowCount() > 0) Gui.model.setRowCount(0);
        for (int i = 1; i <= rowsToGenerate; i++) {
//            row = String.format(rowFormat,
//                    randomizer.getRandomInt(),
//                    randomizer.getRandomLong(),
//                    Lists.getRandomHuman(),
//                    randomizer.getRandomAge(minAge, maxAge),
//                    randomizer.getRandomDouble(minGrade, maxGrade));

            Gui.model.addRow(new Object[] {
                    i,
                    Randomizer.getRandomInt(),
                    Randomizer.getRandomLong(),
                    lists.getRandomHuman(),
                    Randomizer.getRandomAge(minAge, maxAge),
                    Randomizer.getRandomDouble(minGrade, maxGrade),
                    lists.getCar(),
                    lists.getColor()
            });

            //System.out.println(row);
            //rows.add(row + "\n");
        }
//        try {
//            FileWriter.save(rows);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}