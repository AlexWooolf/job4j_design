package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(true, 4, "Mustang", new Engine(100500), new String[]{"bigWheels", "loudExhaust"});

        /* Преобразуем объект person в json-строку. */
        Gson gson = new GsonBuilder().create();
        String jsonCar = gson.toJson(car);
        System.out.println(jsonCar);

        /* Модифицируем json-строку */

        Car carGsonMod = gson.fromJson(jsonCar, Car.class);
        System.out.println(carGsonMod);

        /* JSONObject из json-строки строки */
        JSONObject jsonEngine = new JSONObject("{\"power\":\"100500\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("bigWheels");
        list.add("loudExhaust");
        JSONArray jsontuning = new JSONArray(list);

        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cool", car.isCool());
        jsonObject.put("seats", car.getSeats());
        jsonObject.put("model", car.getModel());
        jsonObject.put("engine", jsonEngine);
        jsonObject.put("tuning", jsontuning);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(car).toString());
    }
}
