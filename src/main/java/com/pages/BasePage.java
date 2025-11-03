package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration; 

public class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait; // 
    //Contructor
    protected BasePage (WebDriver givenDriver) {
        this.driver = givenDriver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(String text) {
        WebElement element = this.driver.findElement(By.xpath(text));
        element.click();
    }
    
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }
    
}
