package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CheckoutTest extends BaseTest {


    @Test
    public void verifySuccesfullPurchase() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        accountSteps.goToCheckout();
        checkoutSteps.fillCheckout();
        checkoutSteps.placeOrder();
        checkoutSteps.verifySuccesfullOrder("Order details");


    }

    @Test
    public void verifyCheckoutCouponMessage() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        accountSteps.goToCheckout();
        checkoutSteps.verifyCheckoutCouponMessage();
    }

    @Test
    public void verifyCheckoutAndFinalOrderPricesTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        accountSteps.goToCheckout();
        checkoutSteps.fillCheckout();
        checkoutSteps.placeOrder();
        checkoutSteps.verifyPriceIsCalculatedCorectly();
    }
    @Test
    public void verifyReturningCustomerMessageTest (){
        loginSteps.navigateToHomepage();
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        accountSteps.goToCheckout();
        checkoutSteps.verifyReturningCustomerMessageBox("Returning customer? Click here to login");

    }
}