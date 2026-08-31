package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.Constants;

import java.util.List;

public class ProductSortingTest extends BaseTest {

    @Test
    public void sortProductsAndRemoveItemTest() {

        productsPage.sortByPriceLowToHigh();

        List<Double> actualPrices = productsPage.getProductPrices();

        List<Double> expectedPrices = actualPrices.stream()
                .sorted()
                .toList();

        Assert.assertEquals(
                actualPrices,
                expectedPrices,
                "Products should be sorted by price from low to high"
        );

        productsPage.addFirstProductToCart();

        Assert.assertEquals(
                productsPage.getCartItemsCount(),
                1,
                "Cart should contain one product"
        );

        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(
                cartPage.getProductName(),
                Constants.ONESIE_NAME,
                "The cheapest product should be added to the cart"
        );

        cartPage.removeProduct();

        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "Cart should be empty after product removal"
        );
    }
}