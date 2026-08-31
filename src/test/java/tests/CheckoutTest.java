package tests;

import base.BaseTest;
import data.TestDataFactory;
import model.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import utils.Constants;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartItemsCount(),
                1,
                "Cart should contain one product"
        );

        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(
                cartPage.getProductName(),
                Constants.BACKPACK_NAME,
                "Unexpected product in the cart"
        );

        CheckoutInformationPage informationPage = cartPage.checkout();

        CheckoutOverviewPage overviewPage =
                informationPage.fillCustomerInformation(
                        TestDataFactory.validCustomer()
                );

        Assert.assertTrue(
                overviewPage.isOpened(),
                "Checkout overview page should be opened"
        );

        Assert.assertEquals(
                overviewPage.getPageTitle(),
                Constants.CHECKOUT_OVERVIEW_TITLE,
                "Unexpected checkout overview page title"
        );

        Assert.assertEquals(
                overviewPage.getProductName(),
                Constants.BACKPACK_NAME,
                "Unexpected product on checkout overview page"
        );

        CheckoutCompletePage completePage = overviewPage.finishOrder();

        Assert.assertTrue(
                completePage.isOpened(),
                "Checkout complete page should be opened"
        );

        Assert.assertEquals(
                completePage.getPageTitle(),
                Constants.CHECKOUT_COMPLETE_TITLE,
                "Unexpected checkout complete page title"
        );

        Assert.assertEquals(
                completePage.getCompleteMessage(),
                Constants.ORDER_COMPLETE_MESSAGE,
                "Unexpected order completion message"
        );
    }
}