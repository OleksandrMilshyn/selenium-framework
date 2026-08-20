package pages;

import base.BasePage;
import model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInformationPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);

        wait.until(
                ExpectedConditions.urlContains("checkout-step-one")
        );
    }

    public CheckoutOverviewPage fillCustomerInformation(Customer customer) {
        logger.info("ACTION: Fill customer information");

        type(firstNameInput, customer.getFirstName());
        type(lastNameInput, customer.getLastName());
        type(postalCodeInput, customer.getPostalCode());
        click(continueButton);

        return new CheckoutOverviewPage(driver);
    }
}
