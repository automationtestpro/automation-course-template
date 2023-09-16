package com.swaglab;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By productsText = By.cssSelector("span.title");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getProductsText() {
        return findElementByLocator(productsText).getText();
    }


}