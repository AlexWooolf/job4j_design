package ru.job4j.serialization.json;

public class Engine {

    private int power;

    public Engine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Engine{" + "power=" + power + '}';
    }
}
