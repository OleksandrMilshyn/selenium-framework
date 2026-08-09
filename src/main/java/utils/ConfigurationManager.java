package utils;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigurationManager {

    private static ConfigurationManager instance;

    private final Properties properties = new Properties();

    private ConfigurationManager() {
        loadProperties();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    private void loadProperties() {
        String environment = System.getProperty("env", "test");

        String fileName = "config-" + environment + ".properties";

        try (InputStream input = ConfigurationManager.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException(
                        "Configuration file not found: " + fileName
                );
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load configuration: " + fileName,
                    e
            );
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
