package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends PageBase {
    
    public ShoppingCart(WebDriver givenDriver) { // constructor
        super(givenDriver);
    }

    // Locators
    private By mgserrorselectitem=By.xpath("//div[@class='woocommerce-notices-wrapper']//div");

    // Methods
    public String getErrorMessage() {
        return findElement(mgserrorselectitem).getText();
    }
}