package driver;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER =
            new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void createDriver() {
        String browser = System.getProperty("browser", "chrome")
                .toLowerCase();

        BrowserDriverCreator creator = switch (browser) {
            case "chrome" -> new ChromeDriverCreator();
            case "firefox" -> new FirefoxDriverCreator();
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        };

        DRIVER.set(creator.createDriver());
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();

        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
