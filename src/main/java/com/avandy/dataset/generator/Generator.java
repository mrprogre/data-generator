package com.avandy.dataset.generator;

import com.avandy.dataset.model.Row;
import com.avandy.dataset.ui.Gui;
import com.avandy.dataset.util.PropertiesUtils;
import com.avandy.dataset.util.Randomizer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<String> rows = new ArrayList<>();
    private final Data data;

    public Generator() {
        this.data = new Data();
    }

    public void generate(long rowCount) {
        generateRows(rowCount);
    }

    private void generateRows(long rowsCount) {
        int minAge = Integer.parseInt(PropertiesUtils.get("generator.minAge"));
        int maxAge = Integer.parseInt(PropertiesUtils.get("generator.maxAge"));
        int minGrade = Integer.parseInt(PropertiesUtils.get("generator.minGrade"));
        int maxGrade = Integer.parseInt(PropertiesUtils.get("generator.maxGrade"));
        int maxOrderCount = Integer.parseInt(PropertiesUtils.get("generator.maxOrderCount"));
        int minOrderAmountSum = Integer.parseInt(PropertiesUtils.get("generator.minOrderAmountSum"));
        int maxOrderAmountSum = Integer.parseInt(PropertiesUtils.get("generator.maxOrderAmountSum"));
        int minYear = Integer.parseInt(PropertiesUtils.get("generator.minYear"));
        int maxYear = Integer.parseInt(PropertiesUtils.get("generator.maxYear"));

        // очистка таблицы и коллекции перед новой генерацией строк
        if (Gui.model.getRowCount() > 0) Gui.model.setRowCount(0);
        if (rows.size() > 0) rows.clear();

        Gui.setStatus("Generation..");
        long start = System.currentTimeMillis();
        for (int i = 1; i <= rowsCount; i++) {
            Row row = Row.builder()
                    .num(i)
                    .intData(Randomizer.getRandomInt())
                    .longData(Randomizer.getRandomLong())
                    .human(data.getRandomHuman())
                    .age((byte) Randomizer.getRandomIntInterval(minAge, maxAge))
                    .doubleData(Randomizer.getRandomDouble(minGrade, maxGrade))
                    .car(data.getCar())
                    .color(data.getColor())
                    .country(data.getCountry())
                    .orderCount((byte) Randomizer.getRandomIntInterval(1, maxOrderCount))
                    .orderAmountSum(Randomizer.getRandomDouble(minOrderAmountSum, maxOrderAmountSum))
                    .lastOrder(LocalDate.of(Randomizer.getRandomIntInterval(minYear, maxYear),
                            Randomizer.getRandomIntInterval(1, 12),
                            Randomizer.getRandomIntInterval(1, 28)))
                    .post(data.getPost())
                    .build();

            Gui.model.addRow(new Object[]{row.getNum(), row.getIntData(), row.getLongData(), row.getHuman(),
                    row.getAge(), row.getDoubleData(), row.getCar(), row.getColor(), row.getCountry(),
                    row.getOrderCount(), row.getOrderAmountSum(), row.getLastOrder(), row.getPost()
            });
        }
        Gui.setStatus("Rows created in " + (System.currentTimeMillis() - start) + " ms.");
    }
}
