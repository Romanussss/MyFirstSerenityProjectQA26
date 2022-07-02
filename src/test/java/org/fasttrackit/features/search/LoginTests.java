package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;


public class LoginTests extends BaseTest {


    @Test
    public void loginWithValidCredentialsTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.verifyUsernameMessage("vladhodisan");
    }

    @Test
    public void loginWithInvalidCredentialsTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials("vladhodisan@yahoo.com ", "123456");
        loginSteps.clickLogin();
        loginSteps.verifySignInErrorMessage("ERROR: The password you entered for the email address vladhodisan@yahoo.com is incorrect. Lost your password?");

    }

    @Test
    public void logInWithoutCredentialsTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.clickLogin();
        loginSteps.verifyMissingUsernameError("Error: Username is required.");
    }


}

