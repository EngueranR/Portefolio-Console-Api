package portefolio.portefolioconsole.BO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Console {
    private Map<String, String> commandMap;
    private ArrayList<Map<String,String>> historyList;


    public Console() {
        commandMap = new HashMap<>();
        historyList = new ArrayList<>();
        consoleInit();
    }

    public void consoleInit() {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Get the JSON file from the resources folder
            InputStream jsonStream = getClass().getResourceAsStream("/assets/command.json");
            // Read JSON file and convert it to a map
            Map<String, List<Map<String, String>>> commands =
                    objectMapper.readValue(jsonStream, new TypeReference<Map<String, List<Map<String, String>>>>(){});

            // Loop through the list and add each command to the commandMap
            for(Map<String, String> command : commands.get("commands")) {
                addConsoleCommand(command.get("command"), command.get("function"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void addConsoleCommand(String request, String answer) {
        commandMap.put(request, answer);
    }

    public String interpretCommand(String command) {
        String response = commandMap.getOrDefault(command, "Commande non reconnue 'help' pour voir les commandes disponible.");
        Map<String,String> commandHistory = new HashMap<>();
        commandHistory.put(command, response);
        historyList.add(commandHistory);
        return response;
    }
    public List<Map<String, String>> getCommandsList() {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Initialize the result
        List<Map<String, String>> result = new ArrayList<>();

        try {
            // Get the JSON file from the resources folder
            InputStream jsonStream = getClass().getResourceAsStream("/assets/command.json");

            // Read JSON file and convert it to a map
            Map<String, List<Map<String, String>>> commands =
                    objectMapper.readValue(jsonStream, new TypeReference<Map<String, List<Map<String, String>>>>(){});

            // Get the list of commands
            result = commands.get("commands");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
