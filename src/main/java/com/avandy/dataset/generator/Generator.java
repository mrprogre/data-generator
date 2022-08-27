package com.avandy.dataset.generator;

import com.avandy.dataset.list.Lists;
import com.avandy.dataset.ui.Gui;
import com.avandy.dataset.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<String> rows = new ArrayList<>();
    private final Lists lists;

    public Generator() {
        this.lists = new Lists();
    }

    public void generate(String rowCount) {
        generateRows(rowCount);
    }

    private void generateRows(String rowsCount) {
        //int firstParam = Integer.parseInt(args[0]);
        int rowsToGenerate = Integer.parseInt(rowsCount);
        final int minAge = 18;
        final int maxAge = 50;
        final int minGrade = 2;
        final int maxGrade = 5;


        String row;
        String rowFormat = "%d;%d;%d;%s;%d;%2f;%s;%s";

        // очистка таблицы и коллекции перед новой генерацией строк
        if (Gui.model.getRowCount() > 0) Gui.model.setRowCount(0);
        if (rows.size() > 0) rows.clear();

        for (int i = 1; i <= rowsToGenerate; i++) {
            // Заполнение таблицы UI
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

            // Строки для выгрузки в файл
            row = String.format(rowFormat,
                    i,
                    Randomizer.getRandomInt(),
                    Randomizer.getRandomLong(),
                    lists.getRandomHuman(),
                    Randomizer.getRandomAge(minAge, maxAge),
                    Randomizer.getRandomDouble(minGrade, maxGrade),
                    lists.getCar(),
                    lists.getColor()
            );
            rows.add(row + "\n");
        }
    }
}