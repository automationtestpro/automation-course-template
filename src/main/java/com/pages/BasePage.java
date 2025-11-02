package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait; // 
    //Contructor
    protected BasePage (WebDriver givenDriver) {
        this.driver = givenDriver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    public void click(String text) {
        WebElement element = this.driver.findElement(By.xpath(text));
        element.click();
    }

    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }


    public void open(String url) {
        driver.get(url);
    }
}
