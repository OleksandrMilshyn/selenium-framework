package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverCreator extends BrowserDriverCreator {

    @Override
    protected FirefoxDriver createWebDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();

        if (isHeadless()) {
            options.addArguments("-headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        } else {
            options.addArguments("--start-maximized");
        }

        return new FirefoxDriver(options);
    }
}
