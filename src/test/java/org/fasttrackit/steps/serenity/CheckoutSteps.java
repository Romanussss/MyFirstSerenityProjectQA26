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
        Assert.assertEquals("Order details", message);
    }


    @Step
    public void verifyCheckoutCouponMessage() {
        Assert.assertTrue(checkoutPage.checkoutCouponMessage());
    }

    @Step
    public void verifyPriceIsCalculatedCorectly() {
        Assert.assertTrue(checkoutPage.checkCheckoutPriceandFinalOrderPrice());
    }

    @Step
    public void verifyReturningCustomerMessageBox(String message) {
        checkoutPage.checkReturningCustomerMessageBox(message);
        Assert.assertEquals("Returning customer? Click here to login", message);
    }

    @Step
    public void verifyMandatoryFieldsAlert() {
        Assert.assertTrue(checkoutPage.checkRequiredFieldsAlert());
    }

}
