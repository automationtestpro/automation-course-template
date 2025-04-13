package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) { // constructor
        super(givenDriver);
    }

    // Locators
    private By logo = By.xpath("(//div[@id=\"logo\"])[1]");
    private By newProductSection = By.id("eweb_new_product-2");

    // Methods
    public void open() {
        findElement(logo).click();
    }

    public Boolean isNewProductSectionDisplay() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(newProductSection));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
