package com.avandy.dataset.util;

import java.util.Random;

public class Randomizer {
    private final Random random = new Random();

    // not unique
    public int getRandomInt() {
        return Math.abs(random.nextInt());
    }

    public int getRandomInt(int value) {
        return random.nextInt(value);
    }

    public int getRandomAge(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

    public long getRandomLong() {
        return Math.abs(random.nextLong());
    }

    // для CSV формата
//    public String getRandomDouble(int min, int max) {
//        return String.valueOf(Util.round(random.nextDouble() * (max - min) + min))
//                .replace(".", ",");
//    }

    public double getRandomDouble(int min, int max) {
        return Util.round(random.nextDouble() * (max - min) + min);
    }

    public boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
