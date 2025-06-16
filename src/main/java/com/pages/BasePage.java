package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver givenDriver) { //constructor to initialize the WebDriver
        this.driver = givenDriver;
        this.wait = new WebDriverWait(driver, 15); // Initialize WebDriverWait with a timeout of 15 seconds
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    public void open(String url) {
        this.driver.get(url);
    }
    public String getTitle() {
        return this.driver.getTitle();
    }
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    public WebElement waitElementVisible(By by) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementPresence(By by) {
        return this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitElementClickable(By by) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean waitElementInvisible(By by) {
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public void clickElement(By by)  {
        // this.driver.findElement(by).click();
        waitElementClickable(by).click();
    }

    public void enterText(By by, String text) {
        WebElement element = waitElementVisible(by);
        element.clear(); // Clear the field before sending keys
        element.sendKeys(text);
    }
}
