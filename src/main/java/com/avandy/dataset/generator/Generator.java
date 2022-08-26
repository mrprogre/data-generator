package com.avandy.dataset.generator;

import com.avandy.dataset.list.PeopleNames;
import com.avandy.dataset.util.FileWriter;
import com.avandy.dataset.util.Randomizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    private final FileWriter fileWriter;
    private final Randomizer randomizer;
    private final PeopleNames peopleNames;

    public Generator() {
        this.fileWriter = new FileWriter();
        this.randomizer = new Randomizer();
        this.peopleNames = new PeopleNames();
    }

    public void generateRows() throws IOException {
        //int firstParam = Integer.parseInt(args[0]);
        final int rowsGenerateCount = 100;
        final int minAge = 18;
        final int maxAge = 50;
        final int minGrade = 2;
        final int maxGrade = 5;
        List<String> rows = new ArrayList<>();

        String row;
        String rowFormat = "%d;%d;%s;%d;%s;";
        for (int i = 0; i < rowsGenerateCount; i++) {
            row = String.format(rowFormat,
                    randomizer.getRandomInt(),
                    randomizer.getRandomLong(),
                    peopleNames.getRandomHuman(),
                    randomizer.getRandomAge(minAge, maxAge),
                    randomizer.getRandomDouble(minGrade, maxGrade));

            System.out.println(row);
            rows.add(row + "\n");
        }
        fileWriter.save(rows);
    }
}