package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BookingPage extends BasicTest {
    
    By requestBtn = By.xpath("//button[@type='button']//div[@class='btnr__btn-text-wrapper']"); 
    
    public BookingPage(WebDriver driver) {
        PageFactory.initElements(driver, this); 
    }

    public void requestBooking() {
        WebElement requestButton = waitElementClickable(requestBtn); 

        // Scroll xuống button 
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", requestButton);
         requestButton.click(); 

        // Chờ form yêu cầu đặt hiện ra
        waitElementVisible(By.xpath("//span[text()='Yêu cầu đặt Combo']"));
    }
}