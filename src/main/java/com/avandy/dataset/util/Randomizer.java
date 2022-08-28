package com.avandy.dataset.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class Randomizer {
    private final Random random = new Random();

    public int getRandomInt() {
        return Math.abs(random.nextInt());
    }

    public int getRandomInt(int value) {
        return random.nextInt(value);
    }

    public int getRandomIntInterval(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

    public long getRandomLong() {
        return Math.abs(random.nextLong());
    }

    public double getRandomDouble(int min, int max) {
        return Util.round(random.nextDouble() * (max - min) + min);
    }

    public boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
