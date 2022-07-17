package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.bcel.generic.CHECKCAST;
import org.fasttrackit.pages.CheckoutPage;
import org.junit.Assert;

public class CheckoutSteps extends ScenarioSteps {
    private CheckoutPage checkoutPage;

    @Step
    public void fillCheckout() {
        checkoutPage.completeCheckoutFields();


    }

    @Step
    public void placeOrder() {
        checkoutPage.placeOrder();
    }

    @Step
    public void verifySuccesfullOrder(String message) {
        checkoutPage.orderSuccesMessage(message);
        Assert.assertTrue(message == "Order details");
    }


    @Step
    public void verifyCheckoutCouponMessage() {
        Assert.assertTrue(checkoutPage.checkoutCouponMessage());
    }
}
