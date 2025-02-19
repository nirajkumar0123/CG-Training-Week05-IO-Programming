package com.ioprogramming.jsondata.handsonpracticeproblems.convertjsontoxml;

import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertJSONToXML {
    public static void main(String[] args) {
        try {
            String content1 = Files.readString(Paths.get("src/main/resources/file1.json"));
            JSONObject json1 = new JSONObject(content1);

            //String xml = XML.toString(json1);
            String xml = "<root>\n" + XML.toString(json1).replace("><", ">\n<") + "\n</root>";

            System.out.println(xml);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
