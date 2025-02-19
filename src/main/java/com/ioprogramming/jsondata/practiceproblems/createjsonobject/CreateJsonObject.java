package com.ioprogramming.jsondata.practiceproblems.createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreateJsonObject {
    public static void main(String[] args) {
        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Chemistry");
        subjects.put("Physics");
        subjects.put("Hindi");
        subjects.put("English");

        Map<String, Object> studentMap = new LinkedHashMap<>();
        studentMap.put("name", "Niraj");
        studentMap.put("age", 21);
        studentMap.put("subjects", subjects);

        JSONObject student = new JSONObject(studentMap);

        System.out.println(student.toString(4));

    }
}
