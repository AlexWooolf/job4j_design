package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(true, 4, "Mustang", new Engine(100500), new String[]{"bigWheels", "loudExhaust"});
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        String carGson = "{" + "\"cool\":true," + "\"seats\":4," + "\"Mustangt\":" + "{" + "\"engine\":\"+100500\"" + "}," + "\"tuning\":" + "[\"bigWheels\",\"loudExhaust\"]" + "}";
        Car carGsonMod = gson.fromJson(carGson, Car.class);
        System.out.println(carGsonMod);
    }
}
