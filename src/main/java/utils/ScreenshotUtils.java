package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtils {

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    private ScreenshotUtils() {
    }

    public static String takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            throw new IllegalArgumentException(
                    "WebDriver cannot be null when taking a screenshot"
            );
        }

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String fileName = testName
                + "_"
                + LocalDateTime.now().format(DATE_FORMAT)
                + ".png";

        Path screenshotsDirectory = Path.of("target", "screenshots");
        Path destination = screenshotsDirectory.resolve(fileName);

        try {
            Files.createDirectories(screenshotsDirectory);
            Files.copy(source.toPath(), destination);

            return destination.toAbsolutePath().toString();
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to save screenshot: " + destination,
                    e
            );
        }
    }
}
