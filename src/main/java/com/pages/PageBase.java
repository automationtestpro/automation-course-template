
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public PageBase(WebDriver givenDriver) {
        this.driver = givenDriver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement findElement(By by) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this.driver.findElement(by);
    }
}
