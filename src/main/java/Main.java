import list.PeopleNames;
import util.FileWriter;
import util.Randomizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final FileWriter fileWriter = new FileWriter();
    private final Randomizer randomizer = new Randomizer();
    private final PeopleNames peopleNames = new PeopleNames();

    public static void main(String[] args) throws IOException {
        new Main().generateRows();
    }

    private void generateRows() throws IOException {
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
            row = String.format(rowFormat, randomizer.getRandomInt(), randomizer.getRandomLong(), peopleNames.getRandomHuman(),
                    randomizer.getRandomAge(minAge, maxAge), randomizer.getRandomDouble(minGrade, maxGrade));
            System.out.println(row);
            rows.add(row + "\n");
        }
        fileWriter.save(rows);
    }
}