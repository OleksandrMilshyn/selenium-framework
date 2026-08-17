package pages;

import base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Constants;

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

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.isDisplayed();
    }

    public void addBackpackToCart() {
        logger.info("ACTION: Add Backpack to cart");
        click(addBackpackButton);
    }

    public void addFirstProductToCart() {
        logger.info("ACTION: Add first product to cart");
        click(addToCartButtons.get(Constants.FIRST_ELEMENT));
    }

    public int getCartItemsCount() {
        return Integer.parseInt(
                wait.until(ExpectedConditions.visibilityOf(cartBadge)).getText()
        );
    }

    public CartPage openCart() {
        logger.info("ACTION: Open shopping cart");
        click(cartLink);
        return new CartPage(driver);
    }

    public void sortByPriceLowToHigh() {
        logger.info("ACTION: Sort products by price (Low to High)");

        Select select = new Select(sortDropdown);
        select.selectByValue(Constants.SORT_LOW_TO_HIGH);

        wait.until(ExpectedConditions.attributeToBe(
                sortDropdown,
                "value",
                Constants.SORT_LOW_TO_HIGH));
    }

    public List<Double> getProductPrices() {
        logger.info("ACTION: Read product prices");

        return productPrices.stream()
                .map(WebElement::getText)
                .map(price -> price.replace(Constants.CURRENCY_SYMBOL, Constants.EMPTY_STRING))
                .map(Double::parseDouble)
                .toList();
    }
}
