package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    @Test
    public void addBackpackToCartTest() {
        ProductsPage productsPage = login();

        Assert.assertTrue(
                productsPage.isOpened(),
                "Products page should be opened after successful login"
        );

        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartItemsCount(),
                "1",
                "Cart should contain one product after adding backpack"
        );

        CartPage cartPage = productsPage.openCart();

        Assert.assertTrue(
                cartPage.isOpened(),
                "Cart page should be opened"
        );

        Assert.assertEquals(
                cartPage.getPageTitle(),
                "Your Cart",
                "Unexpected cart page title"
        );

        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack",
                "Backpack should be displayed in the cart"
        );
    }
}