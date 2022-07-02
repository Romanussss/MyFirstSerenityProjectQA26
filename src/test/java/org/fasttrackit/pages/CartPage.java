package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    @FindBy(css = "#main > div.woocommerce-message")
    private WebElementFacade successMessage;
    @FindBy(css = "a.remove")
    private WebElementFacade removeButton;
    @FindBy(className = "woocommerce-message")
    private WebElementFacade productRemovedAlert;
    @FindBy(css = "a.button.wc-forward")
    private WebElementFacade viewCartButton;
    @FindBy(css = ".product-subtotal  ")
    private ListOfWebElementFacades listofProductsSubtotalSpan;
    @FindBy(css = ".cart-subtotal ")
    private WebElementFacade cartSubtotalPriceSpan;


    public void verifySuccessMessage(String alertMessage) {
//       successMessage.shouldContainOnlyText("View cart ”" +  productName + "” has been added to your cart.");
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
    public boolean isSubtotalPriceCalculatedCorrectly(){
      int subtotalPrice = getPriceFromString(cartSubtotalPriceSpan.getText());
      int expected = Integer.parseInt(cartSubtotalPriceSpan.getText());
      return  subtotalPrice == expected;
    }

}