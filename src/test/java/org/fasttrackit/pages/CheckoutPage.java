package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutPage extends BasePage {

    @FindBy(id = "billing_first_name")
    private WebElementFacade firstNameTextField;
    @FindBy(id = "billing_last_name")
    private WebElementFacade lastNameTextField;
    @FindBy(id = "billing_country")
    private WebElementFacade billingCountrySelector;
    @FindBy(id = "billing_address_1")
    private WebElementFacade bilingAdressTextField;
    @FindBy(id = "billing_address_2")
    private WebElementFacade billingAdressOptionalTextField;
    @FindBy(id = "billing_city")
    private WebElementFacade billingCityTextField;
    @FindBy(css = "#billing_state")
    private WebElementFacade countySelector;
    @FindBy(id = "billing_postcode")
    private WebElementFacade billingPostcodeTextField;
    @FindBy(id = "billing_phone")
    private WebElementFacade billingPhoneNumberTextField;
    @FindBy(id = "billing_email")
    private WebElementFacade billingEmailTextField;
    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;
    @FindBy(className = "woocommerce-order-details__title")
    private WebElementFacade orderSuccesMessage;
    @FindBy(css = "#post-12 > div > div > div")
    private WebElementFacade clickHereToEnterCouponMessage;


    public void completeCheckoutFields() {
        firstNameTextField.type("Vlad");
        lastNameTextField.type("Roman");
        billingCountrySelector.selectByValue("ET");
        bilingAdressTextField.type("Aleea Padin ");
        billingCityTextField.type("Cluj-napoca");
        countySelector.type("Cluj");
        billingPostcodeTextField.type("400556");
        billingPhoneNumberTextField.type("+40758334221");
        billingEmailTextField.type("vladhodisan@yahoo.com");


    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public void orderSuccesMessage(String message) {
        waitFor(orderSuccesMessage);
        orderSuccesMessage.shouldContainOnlyText(message);

    }


    public boolean checkoutCouponMessage() {
        if (clickHereToEnterCouponMessage.isCurrentlyVisible())
            return true;
        else {
            return false;
        }
    }


}
