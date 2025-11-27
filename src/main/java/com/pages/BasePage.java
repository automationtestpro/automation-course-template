package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random; 

public class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait; //
    protected Actions action; //  
    //Contructor .
    protected BasePage (WebDriver givenDriver) {
        this.driver = givenDriver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    public void click(String text) {
        WebElement element = this.driver.findElement(By.xpath(text));
        element.click();
    }
    
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }
    protected WebElement waitElementVisible(By by) {
       // Giả sử 'wait' là WebDriverWait đã được khởi tạo
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // input từng từ
    public static void typeSlowly(WebElement element, String text, int minDelayMs, int maxDelayMs) {
    if (text == null) {
        return;
    }
    Random random = new Random();
    for (char c : text.toCharArray()) {
        element.sendKeys(String.valueOf(c));
        try {
            // Tạo độ trễ ngẫu nhiên trong khoảng [minDelayMs, maxDelayMs]
            int delay = random.nextInt(maxDelayMs - minDelayMs) + minDelayMs;
            Thread.sleep(delay); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
}
