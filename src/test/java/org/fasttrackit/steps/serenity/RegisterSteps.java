package org.fasttrackit.steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.AccountPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.RegisterPage;
import org.junit.Assert;

public class RegisterSteps extends ScenarioSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private RegisterPage registerPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToRegister() {
        homePage.clickAccountLink();
    }

    @Step
    public void setCredentials(String email, String password) {
        registerPage.setEmailField(email);
        registerPage.setPasswordField(password);
    }

    @Step
    public void clickRegister() {
        registerPage.clickRegisterButton();
    }

    @Step
    public void verifyUsernameMessage(String userName) {
        accountPage.verifyWelcomeMessage(userName);
    }


    @Step
    public void verifyRegistryErrorMessage(String Error) {
        registerPage.verifyRegistryErrorMessage(Error);
    }
@Step
    public void verifyWeakPassAndHintAreVisible(){
    Assert.assertTrue(registerPage.checkWeakPassAndHintareVisible());
}
}
