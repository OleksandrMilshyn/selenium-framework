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

public class BaseTest {

    protected final Logger logger = LogManager.getLogger(getClass());

    protected WebDriver driver;
    protected ProductsPage productsPage;

    @BeforeMethod
    public void setUpAndLogin() {
        String browser = System.getProperty(
                "browser",
                ConfigReader.get("browser")
        );
        String environment = System.getProperty("env", "test");

        logger.info(
                "ACTION: Starting test. Browser: {}, environment: {}",
                browser,
                environment
        );

        DriverFactory.createDriver();
        driver = DriverFactory.getDriver();

        logger.info("WebDriver was created successfully");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        logger.info("ACTION: Logging in with configured credentials");

        productsPage = loginPage.loginWithCredentials(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
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
