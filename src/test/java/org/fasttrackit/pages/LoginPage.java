package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.locators.WaitForWebElements;
import net.thucydides.core.pages.PageObject;
import org.fasttrackit.utils.Constants;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade emailField;
    @FindBy(id = "password")
    private WebElementFacade passwordField;
    @FindBy(css = "#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button")
    private WebElementFacade loginButton;
    @FindBy(css = "#post-13 > div > div > ul")
    private WebElementFacade missingUsernameError;
    @FindBy(css = "#post-13 > div > div > ul > li")
    private WebElementFacade signInErrorMessage;
    @FindBy(css = "#customer_login > div.u-column1.col-1 > form > p.woocommerce-LostPassword.lost_password > a")
    private WebElementFacade lostYourPasswordButton;
    @FindBy(id = "user_login")
    private WebElementFacade lostYourPasswordTextField;
    @FindBy(css = "#post-13 > div > div > div")
    private WebElementFacade passwordResetAlert;


    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void setPasswordField(String password) {
        waitFor(passwordField);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(passwordField);
        typeInto(passwordField, password);
    }


    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void verifySignInErrorMessage(String error) {
        missingUsernameError.shouldContainOnlyText(error);
    }

    public void verifyErrorMessage(String error) {
        signInErrorMessage.shouldContainOnlyText(error);

    }

    public void clickLostPasswordButton() {
        lostYourPasswordButton.click();


    }
}





