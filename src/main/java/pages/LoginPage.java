package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        logger.info("ACTION: Open login page");
        driver.get(ConfigReader.get("base.url"));
    }

    public ProductsPage loginWithCredentials(String username, String password) {
        logger.info("ACTION: Login with user credentials");

        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);

        return new ProductsPage(driver);
    }
}
