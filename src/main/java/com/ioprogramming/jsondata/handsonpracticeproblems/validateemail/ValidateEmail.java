package com.ioprogramming.jsondata.handsonpracticeproblems.validateemail;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;

public class ValidateEmail {
    public static void main(String[] args) {
        try {
            Schema schema = SchemaLoader.load(new JSONObject(new JSONTokener(new FileInputStream("src/main/resources/email_schema.json"))));
            schema.validate(new JSONObject(new JSONTokener(new FileInputStream("src/main/resources/email.json"))));
            System.out.println("All emails are valid!");
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}


