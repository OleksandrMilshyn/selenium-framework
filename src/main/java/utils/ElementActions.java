package utils;

import org.openqa.selenium.WebElement;

public interface ElementActions {

    void click(WebElement element);

    void type(WebElement element, String text);
}
