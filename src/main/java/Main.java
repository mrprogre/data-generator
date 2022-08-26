import list.PeopleNames;
import util.FileWriter;
import util.Randomizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final FileWriter WRITER = new FileWriter();
    private static final Randomizer RANDOM = new Randomizer();
    private static final int ROWS_GENERATE_NUM = 1000;
    private static final int MAX_AGE = 80;
    private static final int MIN_GRADE = 2;
    private static final int MAX_GRADE = 5;

    public static void main(String[] args) throws IOException {
//        int firstParam = Integer.parseInt(args[0]);

        PeopleNames names = new PeopleNames();
        List<String> rows = new ArrayList<>();


        String row;
        for (int i = 0; i < ROWS_GENERATE_NUM; i++) {

            row = RANDOM.getRandomInt(MAX_AGE) + ";" +
                    RANDOM.getRandomDouble(MIN_GRADE, MAX_GRADE) + ";" +
                    names.getRandomManName() + " " + names.getManSurname() + ";" +
                    names.getRandomWomanName() + " " + names.getWomanSurname() + ";" +
                    "\n";

            rows.add(row.replace(".", ","));
        }
        WRITER.save(rows);
    }
}