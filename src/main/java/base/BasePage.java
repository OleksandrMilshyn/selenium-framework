package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationManager;
import utils.ElementActions;
import utils.LoggingElementActions;
import utils.SeleniumElementActions;

import java.time.Duration;

public abstract class BasePage {

    protected final Logger logger = LogManager.getLogger(getClass());

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final ElementActions elementActions;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigurationManager.getInstance()
                                        .get("explicit.wait")
                        )
                )
        );

        this.elementActions = new LoggingElementActions(
                new SeleniumElementActions()
        );

        PageFactory.initElements(driver, this);
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));

        elementActions.type(element, text);
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

        elementActions.click(element);
    }
}
