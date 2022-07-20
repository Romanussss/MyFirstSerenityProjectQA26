package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(id = "primary")
    private List<WebElementFacade> productsList;
    @FindBy(css = "select.orderby")
    private WebElementFacade sortByDropdownMenu;
    @FindBy(css = "#main > form")
    private WebElementFacade orderingForm;


    public boolean checkListForProduct(String productName) {
        for (WebElementFacade element : productsList) {
            if (element.findElement(By.cssSelector("h3.entry-title")).getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void selectProductFromList(String product) {
        for (WebElementFacade element : productsList) {
            if (element.findElement(By.cssSelector("h3.entry-title")).getText().equalsIgnoreCase(product)) {
                element.findElement(By.cssSelector("a")).click();
                break;
            }
        }


    }

    public void selectSortBy(String label) {
        selectFromDropdown(sortByDropdownMenu, label);

        System.out.println(sortByDropdownMenu.getText());
    }


    public boolean verifyCorrectItemOrderIsSelected(String label) {

        System.out.println(sortByDropdownMenu.getFirstSelectedOptionVisibleText());
        if (sortByDropdownMenu.getFirstSelectedOptionVisibleText() .equals(label) )

            return true;
        else {
            return false;


        }
    }





}