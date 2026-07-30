package io.github.randomusert.mods.randomuserts_utils.api.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    private static Config config = new Config();


    private static final Logger LOGGER = LoggerFactory.getLogger("randomuserts-utils");

    private static File configFile = new File("config/randomuserts-utils.json");

    public static void load() {
        if (configFile.exists() && !configFile.isDirectory()) {
            LOGGER.debug("Config file found. loading values from config");


            try (FileReader reader = new FileReader(configFile)) {
                config = gson.fromJson(reader, Config.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            LOGGER.debug("Creating config");
            createDefaultConfig();
        }
    }

    public static void createDefaultConfig() {
        Config defaultConfig = new Config();
        String defaultConfigJson = gson.toJson(defaultConfig);

        try {
            FileWriter defConfigWriter = new FileWriter(configFile);

            defConfigWriter.write(defaultConfigJson);
            defConfigWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Gets the config from Config
    public static Config getConfig() {
        return config;
    }
}
