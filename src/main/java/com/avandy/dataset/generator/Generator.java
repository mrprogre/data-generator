package com.avandy.dataset.generator;

import com.avandy.dataset.ui.Gui;
import com.avandy.dataset.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<String> rows = new ArrayList<>();
    private final Data data;

    public Generator() {
        this.data = new Data();
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
            int randomInt = Randomizer.getRandomInt();
            long randomLong = Randomizer.getRandomLong();
            String randomHuman = data.getRandomHuman();
            int randomAge = Randomizer.getRandomAge(minAge, maxAge);
            double randomDouble = Randomizer.getRandomDouble(minGrade, maxGrade);
            String car = data.getCar();
            String color = data.getColor();

            // Заполнение таблицы UI
            Gui.model.addRow(new Object[]{
                    i,
                    randomInt,
                    randomLong,
                    randomHuman,
                    randomAge,
                    randomDouble,
                    car,
                    color
            });

            // Строки для выгрузки в файл
//            row = String.format(rowFormat,
//                    i,
//                    randomInt,
//                    randomLong,
//                    randomHuman,
//                    randomAge,
//                    randomDouble,
//                    car,
//                    color
//            );
//            rows.add(row + "\n");
        }
    }
}
