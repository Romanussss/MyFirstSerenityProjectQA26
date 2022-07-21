package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.ProductPage;
import org.junit.Assert;

public class CartSteps extends ScenarioSteps {

    private ProductPage productPage;
    private CartPage cartPage;


    @Step
    public void verifySuccessMessage(String alertMessage) {
        cartPage.verifySuccessMessage(alertMessage);
    }

    @Step
    public void verifyProductRemovalMessage(String removeMessage) {
        cartPage.verifyProductRemovalMessage(removeMessage);

    }

    @Step
    public void removeProductFromChekout() {
        cartPage.removeProductFromChekout();
    }


    @Step
    public void checkCartSubtotalIsCorrect() {
        Assert.assertTrue(cartPage.isSubtotalPriceCalculatedCorrectly());
    }

    @Step
    public int checkQuantityCart() {
        int a = cartPage.getCartQuantity();
        return a;


    }

    @Step
    public void checkQuantityIsEqual() {
        Assert.assertTrue(productPage.getProductQuantity() == checkQuantityCart());

    }

    @Step
    public void verifyEmptyCouponAllertMessage(String alertMessage) {
        cartPage.clickCouponButton();
        cartPage.verifyEmptyCouponMessage(alertMessage);
        System.out.println(alertMessage);

    }

    @Step
    public void typeIntoCouponField(String couponField) {
        cartPage.useFakeCouponCode(couponField);
        cartPage.clickCouponButton();

    }

    @Step
    public void verifyFakeCouponAllertMessage(String couponAllert) {
        cartPage.couponAllertMessages(couponAllert);
        Assert.assertTrue(couponAllert .equals("Coupon \"qmjr8amw\" does not exist!"));

    }

    @Step
    public void verifyAlreadyUsedCouponAllertMessage(String couponAllert) {
        cartPage.couponAllertMessages(couponAllert);
        Assert.assertTrue(couponAllert.equals("Coupon code already applied!"));


    }

}
