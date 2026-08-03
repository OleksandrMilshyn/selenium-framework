package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments(
                "--disable-features=PasswordLeakDetection,PasswordManagerOnboarding"
        );
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> preferences = new HashMap<>();
        preferences.put("credentials_enable_service", false);
        preferences.put("profile.password_manager_enabled", false);
        preferences.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", preferences);

        driver = new ChromeDriver(options);

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(3));
    }

    protected ProductsPage login() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

        return loginPage.loginWithCredentials(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}