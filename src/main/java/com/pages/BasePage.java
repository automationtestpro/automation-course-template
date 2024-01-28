package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    protected WebElement findElementByLocator(By locator) {
        return this.driver.findElement(locator);
    }

    protected WebElement waitAndFind(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}