package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.fasttrackit.features.search.BaseTest;
import org.openqa.selenium.By;

import javax.swing.text.html.CSS;
import java.time.Duration;

public class RegisterPage extends PageObject {
    @FindBy(id = "reg_email")
    private WebElementFacade emailField;
    @FindBy(id = "reg_password")
    private WebElementFacade passwordField;
    @FindBy(css = "#customer_login > div.u-column2.col-2 > form > p.woocommerce-FormRow.form-row > button")
    private WebElementFacade registerButton;
    @FindBy(css = "#post-13 > div > div > ul > li")
    private WebElementFacade registrationErrorMessage;

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void setPasswordField(String password) {
        waitFor(passwordField);
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(passwordField);
        typeInto(passwordField, password);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void verifyRegistryErrorMessage(String error) {
        registrationErrorMessage.shouldContainOnlyText(error);

    }


}