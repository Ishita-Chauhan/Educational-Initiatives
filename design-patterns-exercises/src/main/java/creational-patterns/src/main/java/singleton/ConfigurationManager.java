package command;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private JsonObject settings;

    private ConfigurationManager() {
        loadSettings();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    private void loadSettings() {
        try (FileReader reader = new FileReader("src/main/resources/config.json")) {
            settings = JsonParser.parseReader(reader).getAsJsonObject();
            System.out.println("Loaded settings: " + settings);
        } catch (IOException e) {
            System.out.println("Error reading config.json: " + e.getMessage());
            settings = new JsonObject(); // Initialize to empty object
        }
    }

    public String getSetting(String key) {
        return settings.has(key) ? settings.get(key).getAsString() : "Setting '" + key + "' not found!";
    }

    public void updateSetting(String key, String value) {
        settings.addProperty(key, value);
        System.out.println("Updated setting: " + key + " = " + value);
        saveSettings();
    }

    private void saveSettings() {
        try (FileWriter writer = new FileWriter("src/main/resources/config.json")) {
            writer.write(settings.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to config.json: " + e.getMessage());
        }
    }
}
