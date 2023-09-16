package com.swaglab;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private By userNameLocator = By.cssSelector("#user-name");
    private By passwordLocator = By.cssSelector("#password");
    private By loginBtn = By.cssSelector("#login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

   public HomePage loginToSwagLab(String userName, String password) {
        sendKeyToElement(userNameLocator,userName);
        sendKeyToElement(passwordLocator,password);
        clickToElement(loginBtn);
        return new HomePage(driver);
   }

}