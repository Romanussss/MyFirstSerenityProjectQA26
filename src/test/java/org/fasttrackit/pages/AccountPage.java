package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.fasttrackit.utils.Constants;
import org.openqa.selenium.By;

public class AccountPage extends PageObject {

    @FindBy(css = "#post-13 > div > div > div > p:nth-child(1) > strong:nth-child(1)")
    private WebElementFacade welcomeText;


    public void verifyWelcomeMessage(String userName) {
        welcomeText.shouldContainOnlyText(userName);
    }


}
