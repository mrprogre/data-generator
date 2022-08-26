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
    private static final int ROWS_GENERATE_NUM = 1000;
    private static final int MAX_AGE = 80;
    private static final int MIN_GRADE = 2;
    private static final int MAX_GRADE = 5;

    public static void main(String[] args) throws IOException {
        generateRows();
    }

    private static void generateRows() throws IOException {
        //int firstParam = Integer.parseInt(args[0]);
        List<String> rows = new ArrayList<>();

        String row;
        for (int i = 0; i < Main.ROWS_GENERATE_NUM; i++) {

            row = NAMES.getRandomManName() + " " + NAMES.getManSurname() + ";" +
                    NAMES.getRandomWomanName() + " " + NAMES.getWomanSurname() + ";" +
                    RANDOM.getRandomInt(MAX_AGE) + ";" +
                    RANDOM.getRandomDouble(MIN_GRADE, MAX_GRADE) + ";" +
                    "\n";

            rows.add(row.replace(".", ","));
        }
        WRITER.save(rows);
    }
}