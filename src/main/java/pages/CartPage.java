package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends AbstractPage {

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
        wait.until(driver -> !productNames.isEmpty());
        return productNames.get(0).getText();
    }

    public CheckoutInformationPage checkout() {
        click(checkoutButton);
        return new CheckoutInformationPage(driver);
    }

    public void removeProduct() {
        click(removeButton);
        wait.until(driver -> productNames.isEmpty());
    }

    public boolean isCartEmpty() {
        return productNames.isEmpty();
    }
}