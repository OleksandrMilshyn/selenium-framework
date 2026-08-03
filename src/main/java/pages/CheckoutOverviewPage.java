package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends AbstractPage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public boolean isOpened() {
        return pageTitle.isDisplayed();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getProductName() {
        logger.info("ACTION: Get product name from checkout overview");

        wait.until(ExpectedConditions.visibilityOf(productName));
        return productName.getText();
    }

    public CheckoutCompletePage finishOrder() {
        logger.info("ACTION: Finish order");

        click(finishButton);
        return new CheckoutCompletePage(driver);
    }
}