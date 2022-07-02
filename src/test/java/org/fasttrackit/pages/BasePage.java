package org.fasttrackit.pages;

import net.thucydides.core.pages.PageObject;

public class BasePage extends PageObject {

    public int getPriceFromString(String price){
String priceFinal =price.replace(",","").replace("lei","");
        return Integer.parseInt(priceFinal);
    }

    }

