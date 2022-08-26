package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Randomizer {
    Random random = new Random();

    public int getRandomInt(int maxValue) {
        return random.nextInt(maxValue);
    }

    public double getRandomDouble(int minValue, int maxValue) {
        return round(random.nextDouble() * (maxValue - minValue) + minValue);
    }

    private double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
