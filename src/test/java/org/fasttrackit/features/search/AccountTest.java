package org.fasttrackit.features.search;

import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class AccountTest extends BaseTest{



    @Test
    public void verifySuccesfullLogOut(){
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        accountSteps.logOut();
        accountSteps.LogOutAssertion();
    }

}
