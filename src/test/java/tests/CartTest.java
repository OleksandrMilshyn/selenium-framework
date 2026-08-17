package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.Constants;

public class CartTest extends BaseTest {

    @Test
    public void addBackpackToCartTest() {

        Assert.assertTrue(
                productsPage.isOpened(),
                "Products page should be opened after successful login"
        );

        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartItemsCount(),
                1,
                "Cart should contain one product after adding backpack"
        );

        CartPage cartPage = productsPage.openCart();

        Assert.assertTrue(
                cartPage.isOpened(),
                "Cart page should be opened"
        );

        Assert.assertEquals(
                cartPage.getPageTitle(),
                Constants.CART_TITLE,
                "Unexpected cart page title"
        );

        Assert.assertEquals(
                cartPage.getProductName(),
                Constants.BACKPACK_NAME,
                "Backpack should be displayed in the cart"
        );
    }
}