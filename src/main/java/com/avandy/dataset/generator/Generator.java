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
        int rowsToGenerate = Integer.parseInt(rowsCount);
        final int minAge = 18;
        final int maxAge = 50;
        final int minGrade = 2;
        final int maxGrade = 5;

        // очистка таблицы и коллекции перед новой генерацией строк
        if (Gui.model.getRowCount() > 0) Gui.model.setRowCount(0);
        if (rows.size() > 0) rows.clear();

        for (int i = 1; i <= rowsToGenerate; i++) {
            // Заполнение таблицы UI
            Gui.model.addRow(new Object[]{
                    i,
                    Randomizer.getRandomInt(),
                    Randomizer.getRandomLong(),
                    data.getRandomHuman(),
                    Randomizer.getRandomAge(minAge, maxAge),
                    Randomizer.getRandomDouble(minGrade, maxGrade),
                    data.getCar(),
                    data.getColor()
            });
        }
    }
}
