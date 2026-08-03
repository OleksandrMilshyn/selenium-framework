package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);

        wait.until(
                ExpectedConditions.urlContains("checkout-complete")
        );
    }

    public boolean isOpened() {
        return pageTitle.isDisplayed();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getCompleteMessage() {
        logger.info("ACTION: Read order completion message");

        return completeHeader.getText();
    }
}