package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.AccountPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Wait;

public class LoginSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToLogin() {
        homePage.clickAccountLink();
    }

    @Step
    public void setCredentials(String email, String pass) {
        loginPage.setEmailField(email);
        loginPage.setPasswordField(pass);
    }

    @Step
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Step
    public void verifyUsernameMessage(String userName) {
        accountPage.verifyWelcomeMessage(userName);
    }

    @Step
    public void doLogin(String email, String password) {
        navigateToHomepage();
        navigateToLogin();
        setCredentials(email, password);
        clickLogin();
    }

    @Step
    public void verifySignInErrorMessage(String error) {
        loginPage.verifyErrorMessage(error);


    }

    @Step
    public void verifyMissingUsernameError(String error) {
        loginPage.verifySignInErrorMessage(error);
    }

    @Step
    public void resetPassword() {

        loginPage.clickLostPasswordButton();


    }
}