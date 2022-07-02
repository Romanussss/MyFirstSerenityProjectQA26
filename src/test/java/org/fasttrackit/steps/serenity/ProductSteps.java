package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrackit.pages.ProductPage;
import org.fasttrackit.pages.SearchResultsPage;

public class ProductSteps extends ScenarioSteps {

    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;

    @Step
    public void selectProductFromList(String product) {
        searchResultsPage.selectProductFromList(product);
    }
    @Step
    public void goToCart(){
        productPage.viewCart();
    }
    @Step
    public void selectQuantity(){
        productPage.adjustProductQuantity();}

}
