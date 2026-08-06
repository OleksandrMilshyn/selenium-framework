package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    private ConfigReader() {
    }

    private static void loadProperties() {
        if (!properties.isEmpty()) {
            return;
        }

        String environment = System.getProperty("env", "test");
        String fileName = "config-" + environment + ".properties";

        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException(
                        "Configuration file not found: " + fileName
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load configuration file: " + fileName,
                    e
            );
        }
    }

    public static String get(String key) {
        loadProperties();

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Property not found: " + key);
        }

        return value;
    }
}
