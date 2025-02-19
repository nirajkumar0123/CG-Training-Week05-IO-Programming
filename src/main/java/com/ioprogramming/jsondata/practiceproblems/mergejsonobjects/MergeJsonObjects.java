package com.ioprogramming.jsondata.practiceproblems.mergejsonobjects;

import org.json.JSONObject;

public class MergeJsonObjects {
    public static void main(String[] args) {
        String path = "src/main/resources/merge_jsonobject.json";

        JSONObject json1 = new JSONObject();
        json1.put("name", "Rahul");
        json1.put("email", "rahul@example.com");

        JSONObject json2 = new JSONObject();
        json2.put("age", 25);
        json2.put("city", "Madhya Pradesh");

        // Merge json2 into json1
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }
        System.out.println(json1.toString(4));
    }
}
