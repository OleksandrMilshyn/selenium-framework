package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    private static final int FIRST_ELEMENT = 0;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = "button[id^='remove-']")
    private WebElement removeButton;

    public CartPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlContains("cart"));
    }

    public boolean isOpened() {
        return pageTitle.isDisplayed();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getProductName() {
        logger.info("ACTION: Get product name from cart");

        wait.until(
                ExpectedConditions.visibilityOfAllElements(productNames)
        );
        return productNames.get(FIRST_ELEMENT).getText();
    }

    public CheckoutInformationPage checkout() {
        logger.info("ACTION: Proceed to checkout");

        click(checkoutButton);
        return new CheckoutInformationPage(driver);
    }

    public void removeProduct() {
        logger.info("ACTION: Remove product from cart");

        click(removeButton);
        wait.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.className("inventory_item_name"),
                        0
                )
        );
    }

    public boolean isCartEmpty() {
        logger.info("ACTION: Verify cart is empty");

        return productNames.isEmpty();
    }
}
