package driver;

import org.openqa.selenium.WebDriver;

public abstract class BrowserDriverCreator {

    public WebDriver createDriver() {
        return createWebDriver();
    }

    protected abstract WebDriver createWebDriver();

    protected boolean isHeadless() {
        return Boolean.parseBoolean(
                System.getProperty("headless", "false")
        );
    }
}
