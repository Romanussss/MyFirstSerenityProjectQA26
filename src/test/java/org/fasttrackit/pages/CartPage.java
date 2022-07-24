package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "#main > div.woocommerce-message")
    private WebElementFacade successMessage;
    @FindBy(css = "a.remove")
    private WebElementFacade removeButton;
    @FindBy(className = "woocommerce-message")
    private WebElementFacade productRemovedAlert;
    @FindBy(css = "a.button.wc-forward")
    private WebElementFacade viewCartButton;
    @FindBy(css = ".product-subtotal > span.woocommerce-Price-amount.amount")
    private List<WebElementFacade> listofProductsSubtotalSpan;
    @FindBy(css = ".cart-subtotal ")
    private WebElementFacade cartSubtotalPriceSpan;
    @FindBy(css = ".input-text.qty.text")
    private WebElementFacade cartQuantityField;
    @FindBy(css = "input.button")
    private WebElementFacade couponButton;
    @FindBy(css = "ul.woocommerce-error")
    private WebElementFacade couponAllertMessage;
    @FindBy(css = "input#coupon_code.input-text")
    private WebElementFacade couponCodeTextField;
    @FindBy(css = "#post-11 > div > div > div")
    private WebElementFacade emptyCartAlertMessage;


    public void verifySuccessMessage(String alertMessage) {
        viewCartButton.shouldContainOnlyText("View cart");
    }

    public void removeProductFromChekout() {
        removeButton.click();
    }

    public void verifyProductRemovalMessage(String productName) {
        productRemovedAlert.shouldContainText("“" + productName + "”" + " removed. Undo?");

    }

    public int getSubtotalPriceFromProducts() {
        int sum = 0;
        for (WebElementFacade element : listofProductsSubtotalSpan) {
            sum += getPriceFromString(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCalculatedCorrectly() {
        int subtotalPrice = getPriceFromString(cartSubtotalPriceSpan.getText());
        int expected = getSubtotalPriceFromProducts();
        System.out.println("ok");
        return subtotalPrice == expected;
    }

    public int getCartQuantity() {
        int a = Integer.parseInt(cartQuantityField.getValue());
        System.out.println(a);
        System.out.println("Cart");
        return a;
    }

    public void clickCouponButton() {
        couponButton.click();
    }

    public void verifyEmptyCouponMessage(String alertMessage) {
        couponAllertMessage.getText();
        couponAllertMessage.shouldContainOnlyText("Please enter a coupon code.");
    }

    public void useFakeCouponCode(String fakeCouponCode) {
        couponCodeTextField.select();
        typeInto(couponCodeTextField, fakeCouponCode);

    }

    public void couponAllertMessages(String couponAllert) {
        couponAllertMessage.shouldContainOnlyText(couponAllert);

    }
    public boolean checkEmptyCartMessageIsDisplayed(){
        System.out.println(emptyCartAlertMessage.getText());
        if (emptyCartAlertMessage.isCurrentlyVisible()
                &&emptyCartAlertMessage.getText().equals("Checkout is not available whilst your cart is empty."))
            return true;
        else{
            return false;
        }
    }
}
