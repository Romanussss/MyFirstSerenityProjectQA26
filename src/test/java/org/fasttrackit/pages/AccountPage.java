package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.fasttrackit.utils.Constants;
import org.openqa.selenium.By;

public class AccountPage extends PageObject {

    @FindBy(css = "#post-13 > div > div > div > p:nth-child(1) > strong:nth-child(1)")
    private WebElementFacade welcomeText;
    @FindBy(css = "lost-password")
    private WebElementFacade lostYourPasswordButton;
    @FindBy(id = "user_login")
    private WebElementFacade lostYourPasswordTextField;
    @FindBy(css = "#post-13 > div > div > div")
    private WebElementFacade passwordResetAlert;
    @FindBy(id = "menu-item-1729")
    private WebElementFacade checkout;
    @FindBy(css = "#post-13 > div > div > form > p:nth-child(4) > button")
    private WebElementFacade resetPasswordButton;
    @FindBy(css = "#post-13 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")
    private WebElementFacade logOutButton;
    @FindBy(css = "#customer_login > div.u-column1.col-1 > h2")
    private WebElementFacade logOutAssertion;
    @FindBy(css = "#menu-item-1728 > a")
    private WebElementFacade shopButton;


    public void verifyWelcomeMessage(String userName) {
        welcomeText.shouldContainOnlyText(userName);
    }

    public void setLostYourPasswordTextField(String email) {
        typeInto(lostYourPasswordTextField, email);
    }

    public void verifyPasswordResetAlert(String alert) {
        passwordResetAlert.shouldContainOnlyText(alert);
    }

    public void ClickCheckoutButton() {
        clickOn(checkout);
    }

    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    public void clickLogOut() {
        logOutButton.click();
    }

    public boolean logOutAssertion() {
        if (logOutAssertion.isCurrentlyVisible())
            return true;
        else {
            return false;


        }

    }
public void clickShopButton(){shopButton.click();}
}
