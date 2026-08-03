package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {
        String expectedProductName = "Sauce Labs Backpack";
        String firstName = "Alex";
        String lastName = "Tester";
        String postalCode = "00-001";

        ProductsPage productsPage = login();

        Assert.assertTrue(
                productsPage.isOpened(),
                "Products page should be opened after successful login"
        );

        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartItemsCount(),
                "1",
                "Cart should contain one product"
        );

        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(
                cartPage.getProductName(),
                expectedProductName,
                "Unexpected product in the cart"
        );

        CheckoutInformationPage informationPage = cartPage.checkout();

        CheckoutOverviewPage overviewPage =
                informationPage.fillCustomerInformation(
                        firstName,
                        lastName,
                        postalCode
                );

        Assert.assertTrue(
                overviewPage.isOpened(),
                "Checkout overview page should be opened"
        );

        Assert.assertEquals(
                overviewPage.getPageTitle(),
                "Checkout: Overview",
                "Unexpected checkout overview page title"
        );

        Assert.assertEquals(
                overviewPage.getProductName(),
                expectedProductName,
                "Unexpected product on checkout overview page"
        );

        CheckoutCompletePage completePage = overviewPage.finishOrder();

        Assert.assertTrue(
                completePage.isOpened(),
                "Checkout complete page should be opened"
        );

        Assert.assertEquals(
                completePage.getPageTitle(),
                "Checkout: Complete!",
                "Unexpected checkout complete page title"
        );

        Assert.assertEquals(
                completePage.getCompleteMessage(),
                "Thank you for your order!",
                "Unexpected order completion message"
        );
    }
}