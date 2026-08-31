package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LoginSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Before
    public void setUp() {
        DriverFactory.createDriver();
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Given("user opens the login page")
    public void userOpensLoginPage() {
        loginPage.open();
    }

    @When("^user logs in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLogsIn(String username, String password) {
        productsPage = loginPage.loginWithCredentials(username, password);
    }

    @Then("products page is displayed")
    public void productsPageIsDisplayed() {
        Assert.assertTrue(productsPage.isOpened());
    }
}
