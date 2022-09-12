package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {

    private boolean cool;
    private int seats;
    private String model;
    private Engine engine;
    private String[] tuning;

    @Override
    public String toString() {
        return "Car{" + "cool=" + cool + ", seats=" + seats + ", model='" + model + '\'' + ", engine=" + engine + ", tuning=" + Arrays.toString(tuning) + '}';
    }

    public Car(boolean cool, int seats, String model, Engine engine, String[] tuning) {
        this.cool = cool;
        this.seats = seats;
        this.model = model;
        this.engine = engine;
        this.tuning = tuning;
    }
}
