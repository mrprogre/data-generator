import list.PeopleNames;
import util.FileWriter;
import util.Randomizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final FileWriter WRITER = new FileWriter();
    private static final Randomizer RANDOM = new Randomizer();
    private static final PeopleNames NAMES = new PeopleNames();
    private static final int ROWS_GENERATE_COUNT = 100;
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 50;
    private static final int MIN_GRADE = 2;
    private static final int MAX_GRADE = 5;

    public static void main(String[] args) throws IOException {
        new Main().generateRows();
    }

    private void generateRows() throws IOException {
        //int firstParam = Integer.parseInt(args[0]);
        List<String> rows = new ArrayList<>();

        String row;
        String rowFormat = "%d;%d;%s;%d;%s;";
        for (int i = 0; i < ROWS_GENERATE_COUNT; i++) {
            row = String.format(rowFormat, RANDOM.getRandomInt(), RANDOM.getRandomLong(), NAMES.getRandomHuman(),
                    RANDOM.getRandomAge(MIN_AGE, MAX_AGE), RANDOM.getRandomDouble(MIN_GRADE, MAX_GRADE));
            System.out.println(row);
            rows.add(row + "\n");
        }
        WRITER.save(rows);
    }
}