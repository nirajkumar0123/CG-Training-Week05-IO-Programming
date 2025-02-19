package com.ioprogramming.jsondata.handsonpracticeproblems.convertlisttoarray;

import com.ioprogramming.jsondata.practiceproblems.convertlisttojsonarray.Car;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConvertListOfObjectsToArray {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 200000));
        cars.add(new Car("Honda", "Civic", 202100));
        cars.add(new Car("Ford", "Mustang", 202300));

        JSONArray jsonArray = new JSONArray();

        for (Car car : cars) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("brand", car.getBrand());
            jsonObject.put("model", car.getModel());
            jsonObject.put("price", car.getPrice());

            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray.toString(4));
    }
}
