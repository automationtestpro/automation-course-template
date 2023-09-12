package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{


    private By userNameAfterLogin = By.xpath("//span[@class='username-header']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameText() {
        return findElementByLocator(userNameAfterLogin).getText();
    }



}
