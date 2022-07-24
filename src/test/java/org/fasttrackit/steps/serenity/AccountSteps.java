package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.AccountPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.utils.Constants;
import org.junit.Assert;

public class AccountSteps extends ScenarioSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Step
    public void verifyPasswordResetSuccesMessage(String alert) {
        accountPage.verifyPasswordResetAlert(alert);
        Assert.assertTrue(alert.equals("Password reset email has been sent."));
    }


    @Step
    public void inputResetPasswordField() {
        accountPage.setLostYourPasswordTextField(Constants.USER_EMAIL);
        accountPage.clickResetPasswordButton();
    }

    @Step
    public void goToCheckout() {
        accountPage.ClickCheckoutButton();
    }

    @Step
    public void logOut() {
        accountPage.clickLogOut();
    }


    @Step
    public void LogOutAssertion() {
        Assert.assertTrue(accountPage.logOutAssertion());
    }

    @Step
    public void goToShop() {
        accountPage.clickShopButton();
    }

    @Step
    public void verifyIfAccountButtonsAreInteractible() {
        Assert.assertTrue(accountPage.checkAccountButtonsAreInteractible());
    }
}

