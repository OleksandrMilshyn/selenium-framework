package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends AbstractPage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(css = ".inventory_item button")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> productPrices;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public boolean isOpened() {
        return pageTitle.isDisplayed();
    }

    public void addBackpackToCart() {
        click(addBackpackButton);
    }

    public void addFirstProductToCart() {
        click(addToCartButtons.get(0));
    }

    public String getCartItemsCount() {
        return wait.until(
                ExpectedConditions.visibilityOf(cartBadge)
        ).getText();
    }

    public CartPage openCart() {
        click(cartLink);
        return new CartPage(driver);
    }

    public void sortByPriceLowToHigh() {
        Select select = new Select(sortDropdown);
        select.selectByValue("lohi");

        wait.until(
                ExpectedConditions.attributeToBe(
                        sortDropdown,
                        "value",
                        "lohi"
                )
        );
    }

    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }
}