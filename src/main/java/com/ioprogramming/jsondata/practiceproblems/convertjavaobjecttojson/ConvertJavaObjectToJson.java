package com.ioprogramming.jsondata.practiceproblems.convertjavaobjecttojson;

import org.json.JSONObject;

public class ConvertJavaObjectToJson {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 28000.50, "180Km/h");

        // Convert Car object to JSON
        JSONObject carJson = new JSONObject();
        carJson.put("brand", car.getBrand());
        carJson.put("model", car.getModel());
        carJson.put("price", car.getPrice());
        carJson.put("speed", car.getSpeed());

        System.out.println(carJson.toString(4));
    }
}
