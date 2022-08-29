package com.avandy.dataset.util;

import com.avandy.dataset.generator.Data;
import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class Randomizer extends Data {
    private final Random random = new Random();

    public int getRandomInt() {
        return Math.abs(random.nextInt());
    }

    public int getRandomInt(int value) {
        return random.nextInt(value);
    }

    public int getRandomIntByInterval(int min, int max) {
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

    // Men
    public String getManName() {
        return menNames[Randomizer.getRandomInt(menNames.length)];
    }

    public String getManSurname() {
        return menSurnames[Randomizer.getRandomInt(menSurnames.length)];
    }

    public String getManNameAndSurname() {
        return getManName() + " " + getManSurname();
    }

    // Women
    public String getWomanName() {
        return womenNames[Randomizer.getRandomInt(womenNames.length)];
    }

    public String getSurname() {
        return menSurnames[Randomizer.getRandomInt(menSurnames.length)] + "а";
    }

    public String getWomenNameAndSurname() {
        return getWomanName() + " " + getSurname();
    }

    // Random human
    public String getRandomHuman() {
        return Randomizer.getRandomBoolean() ? getManNameAndSurname() : getWomenNameAndSurname();
    }

    // Color
    public String getColor() {
        return color[Randomizer.getRandomInt(color.length)];
    }

    // Car
    public String getCar() {
        return car[Randomizer.getRandomInt(car.length)];
    }

    // Country
    public String getCountry() {
        return country[Randomizer.getRandomInt(country.length)];
    }

    // Должность
    public String getPost() {
        return post[Randomizer.getRandomInt(post.length)];
    }
}
