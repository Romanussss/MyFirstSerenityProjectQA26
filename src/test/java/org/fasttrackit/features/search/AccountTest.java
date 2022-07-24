package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class AccountTest extends BaseTest {


    @Test
    public void verifySuccesfullLogOutTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        accountSteps.logOut();
        accountSteps.LogOutAssertion();
    }

    @Test
    public void verifyAccountButtonsTest() {
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        accountSteps.verifyIfAccountButtonsAreInteractible();
    }
}
