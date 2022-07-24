package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa3.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(css = "#menu-item-1730 > a")
    private WebElementFacade signIn;
    @FindBy(css = "#menu-item-1728 > a")
    private WebElementFacade shoplink;
    @FindBy(id = "menu-item-1729")
    private WebElementFacade checkout;
    @FindBy(id = "menu-item-1730")
    private WebElementFacade myaccount;
    @FindBy(css = "#masthead > div.site-top-bar.border-bottom > div > div.site-top-bar-right > i")
    private WebElementFacade searchbutton;
    @FindBy(css = "input.search-field")
    private WebElementFacade searchField;
    @FindBy(css = "input.search-submit")
    private WebElementFacade searchbutton2;


    public void clickAccountLink() {
        clickOn(signIn);
    }


    public void setSearchField(String keyword) {
        clickOn(searchbutton);
        typeInto(searchField, keyword);
    }


    public void clickSearchIcon() {
        waitFor(searchField);
        clickOn(searchbutton2);

    }


}
