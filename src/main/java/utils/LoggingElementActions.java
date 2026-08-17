package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class LoggingElementActions implements ElementActions {

    private final ElementActions elementActions;
    private final Logger logger = LogManager.getLogger(LoggingElementActions.class);

    public LoggingElementActions(ElementActions elementActions) {
        this.elementActions = elementActions;
    }

    @Override
    public void click(WebElement element) {
        logger.info("ACTION: Clicking element");
        elementActions.click(element);
    }

    @Override
    public void type(WebElement element, String text) {
        logger.info("ACTION: Entering text into element");
        elementActions.type(element, text);
    }
}
