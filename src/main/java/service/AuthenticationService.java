package service;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigurationManager;

public class AuthenticationService {

    private final WebDriver driver;

    public AuthenticationService(WebDriver driver) {
        this.driver = driver;
    }

    public ProductsPage login() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

        return loginPage.loginWithCredentials(
                ConfigurationManager.getInstance().get("username"),
                ConfigurationManager.getInstance().get("password")
        );
    }
}