package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
            
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By byMenu1 = By.xpath("//a[contains(text(),'Hệ thống truyền động, Khung gầm')]");
    
    public void hoverMenu1() {
        WebElement menu1 = driver.findElement(byMenu1);
        actions.moveToElement(menu1).perform();
    }
    
    
}
