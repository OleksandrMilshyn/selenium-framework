package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInformationPage extends AbstractPage {

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

    public CheckoutOverviewPage fillCustomerInformation(
            String firstName,
            String lastName,
            String postalCode
    ) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
        click(continueButton);

        return new CheckoutOverviewPage(driver);
    }
}