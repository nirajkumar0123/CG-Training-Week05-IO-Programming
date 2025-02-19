package com.ioprogramming.jsondata.iplandcensoranalyzer;

import org.json.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInput = "src/main/resources/ipl_data.json";
        String jsonOutput = "src/main/resources/censored_ipl_data.json";
        String csvInput = "src/main/resources/ipl_data.csv";
        String csvOutput = "src/main/resources/censored_ipl_data.csv";

        processJSON(jsonInput, jsonOutput);
        processCSV(csvInput, csvOutput);
    }

    private static void processJSON(String inputFile, String outputFile) {
        try {
            String content = Files.readString(Paths.get(inputFile));
            JSONArray matches = new JSONArray(content);

            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);
                censorMatchData(match);
            }

            Files.write(Paths.get(outputFile), matches.toString(4).getBytes());
            System.out.println("Censored JSON file created successfully!");
        } catch (IOException e) {
            System.err.println("Error processing JSON: " + e.getMessage());
        }
    }

    private static void processCSV(String inputFile, String outputFile) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));

            if (lines.isEmpty()) {
                System.err.println("Error: CSV file is empty!");
                return;
            }

            List<String> outputLines = new ArrayList<>();
            outputLines.add(lines.get(0)); // Keep header

            for (int i = 1; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",", -1);

                if (data.length != 7) { // Ensure proper column count
                    System.err.println("Skipping invalid row: " + lines.get(i));
                    continue;
                }

                data[1] = maskTeamName(data[1]);  // Mask team1
                data[2] = maskTeamName(data[2]);  // Mask team2
                data[6] = "REDACTED";             // Redact player_of_match

                outputLines.add(String.join(",", data));
            }

            Files.write(Paths.get(outputFile), outputLines);
            System.out.println("Censored CSV file created successfully!");
        } catch (IOException e) {
            System.err.println("Error processing CSV: " + e.getMessage());
        }
    }

    private static void censorMatchData(JSONObject match) {
        match.put("team1", maskTeamName(match.getString("team1")));
        match.put("team2", maskTeamName(match.getString("team2")));
        match.put("player_of_match", "REDACTED");

        JSONObject score = match.getJSONObject("score");
        updateScoreKeys(score, match.getString("team1"), match.getString("team2"));
    }

    private static void updateScoreKeys(JSONObject score, String team1, String team2) {
        if (score.has(team1)) {
            score.put(maskTeamName(team1), score.remove(team1));
        }
        if (score.has(team2)) {
            score.put(maskTeamName(team2), score.remove(team2));
        }
    }

    private static String maskTeamName(String team) {
        String[] words = team.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***"; // Mask last word
        }
        return String.join(" ", words);
    }
}


