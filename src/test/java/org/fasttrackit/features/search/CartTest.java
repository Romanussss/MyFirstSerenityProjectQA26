package org.fasttrackit.features.search;

import net.serenitybdd.core.pages.WebElementFacade;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        cartSteps.verifySuccessMessage("View cart");
    }

    @Test
    public void removeProductFromCartTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        productSteps.goToCart();
        cartSteps.removeProductFromChekout();
        cartSteps.verifyProductRemovalMessage("Beanie with Logo");
    }

    @Test
    public void verifyProductAndCartQuantityIsEqualTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.selectQuantity();
        productSteps.clickAddToCart();
        productSteps.goToCart();
        cartSteps.checkQuantityIsEqual();


    }

    @Test
    public void verifyCheckoutPrices() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        productSteps.goToCart();
        cartSteps.checkCartSubtotalIsCorrect();

    }

    @Test
    public void verifyEmptyCouponFieldAlertMessageTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        productSteps.goToCart();
        cartSteps.verifyEmptyCouponAllertMessage("Please enter a coupon code.");
    }

    @Test
    public void verifyInvalidCouponAlertMessageTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        productSteps.goToCart();
        cartSteps.typeIntoCouponField("QMJR8AMW");
        cartSteps.verifyFakeCouponAllertMessage("Coupon \"qmjr8amw\" does not exist!");
    }

    @Test
    public void verifyAlreadyUsedCouponAlertMessageTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.doSearch("Beanie");
        productSteps.selectProductFromList("Beanie with Logo");
        productSteps.clickAddToCart();
        productSteps.goToCart();
        cartSteps.typeIntoCouponField("fyjed");
        cartSteps.verifyAlreadyUsedCouponAllertMessage("Coupon code already applied!");
    }
}