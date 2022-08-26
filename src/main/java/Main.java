import list.PeopleNames;
import util.FileWriter;
import util.Randomizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        int firstParam = Integer.parseInt(args[0]);
        int firstParam = 10000;
        FileWriter fileWriter = new FileWriter();
        Randomizer random = new Randomizer();
        PeopleNames names = new PeopleNames();
        List<String> rows = new ArrayList<>();

        String row;
        for (int i = 0; i < firstParam; i++) {

            row = random.getRandomInt(80) + ";" +
                    random.getRandomDouble(2, 5) + ";" +
                    names.getRandomManName() + " " + names.getManSurname() + ";" +
                    names.getRandomWomanName() + " " + names.getWomanSurname() + ";" +
                    "\n";

            rows.add(row.replace(".", ","));
        }
        fileWriter.save(rows);
    }
}