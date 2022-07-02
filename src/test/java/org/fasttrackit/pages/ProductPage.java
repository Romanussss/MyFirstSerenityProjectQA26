package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class ProductPage extends PageObject {

    @FindBy(css = "button.single_add_to_cart_button.button,alt")
    private WebElementFacade addToCartButton;
    @FindBy(css = "i.fa.fa-shopping-cart")
    private WebElementFacade viewCartButton;
    @FindBy(css = "div.screen-reader-text")
    private WebElementFacade productQuantity;

    public void clickAddToCartButton() {
        clickOn(addToCartButton);
    }

    public void viewCart() {
        viewCartButton.click();
    }

    public void adjustProductQuantity() {
//       waitFor(productQuantity).waitUntilClickable();
//    productQuantity.selectByValue("5");
       typeInto(productQuantity,"5");

    }
}


