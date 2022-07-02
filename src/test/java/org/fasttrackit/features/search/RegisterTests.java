package org.fasttrackit.features.search;

import org.fasttrackit.pages.RegisterPage;
import org.fasttrackit.utils.Constants;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTests extends BaseTest {


    @Test
    public void registerWithValidCredentialsTest(){
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        String USER = Constants.USER_RANDOM_EMAIL;
        registerSteps.setCredentials(USER,Constants.USER_RANDOM_PASSWORD);
        registerSteps.clickRegister();
        registerSteps.verifyUsernameMessage(USER.substring(0,USER.length()-10));

    }

@Test
    public void registerWithEmailAlreadyUsedTest(){
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        registerSteps.setCredentials(Constants.USER_EMAIL,Constants.USER_PASS);
        registerSteps.clickRegister();
        registerSteps.verifyRegistryErrorMessage("Error: An account is already registered with your email address. Please log in.");
}

}
