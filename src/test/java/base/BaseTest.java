package base;

import driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ProductsPage;
import service.AuthenticationService;

public class BaseTest {

    protected final Logger logger = LogManager.getLogger(getClass());

    protected WebDriver driver;
    protected ProductsPage productsPage;

    @BeforeMethod
    public void setUpAndLogin() {
        String browser = System.getProperty(
                "browser",
                "chrome"
        );

        String environment = System.getProperty(
                "env",
                "test"
        );

        logger.info(
                "ACTION: Starting test. Browser: {}, environment: {}",
                browser,
                environment
        );

        DriverFactory.createDriver();
        driver = DriverFactory.getDriver();

        logger.info("WebDriver was created successfully");

        AuthenticationService authenticationService =
                new AuthenticationService(driver);

        logger.info("ACTION: Logging in with configured credentials");

        productsPage = authenticationService.login();
        logger.info("ACTION: Login successful. Products page is opened");
    }

    @AfterMethod
    public void tearDown() {
        if (DriverFactory.getDriver() != null) {
            logger.info("ACTION: Closing browser");
            DriverFactory.quitDriver();
        }
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}