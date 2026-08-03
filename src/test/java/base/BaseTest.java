package base;

import driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected final Logger logger = LogManager.getLogger(getClass());

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        String environment = System.getProperty("env", "test");

        logger.info(
                "ACTION: Starting test. Browser: {}, environment: {}",
                browser,
                environment
        );

        driver = DriverFactory.createDriver();

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(3));

        logger.debug("WebDriver was created successfully");
    }

    protected ProductsPage login() {
        logger.info("ACTION: Opening login page");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        logger.info("ACTION: Logging in with configured credentials");

        return loginPage.loginWithCredentials(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("ACTION: Closing browser");
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}