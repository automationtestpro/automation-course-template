package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public WebDriverWait webDriverWait ;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void openUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    protected void clickToElement(By locator) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        findElementByLocator(locator).click();
    }

    protected  void waitForElementVisible(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findElementByLocator(By locator) {
        return driver.findElement(locator);
    }


    public void sendKeyToElement(By locatorType, String textValue) {
        waitForElementVisible(locatorType);
        WebElement element = findElementByLocator(locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    public String getElementValidationMessage(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }




}