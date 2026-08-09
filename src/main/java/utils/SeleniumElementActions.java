package utils;

import org.openqa.selenium.WebElement;

public class SeleniumElementActions implements ElementActions {

    @Override
    public void click(WebElement element) {
        element.click();
    }

    @Override
    public void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
