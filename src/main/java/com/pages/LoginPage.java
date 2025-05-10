package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    
    public LoginPage(WebDriver givenDriver) { // constructor
        super(givenDriver);
    }

    // Locators
    private By usernameFiled=By.xpath("//input[@id='username']");
    private By passwordFiled=By.xpath("//input[@name='password']");
    private By loginbtn=By.xpath("//button[@name='login']");
    private By mgserror=By.xpath("//strong[contains(text(),\"thanhvinh231198\")]");

    // Methods
    public LoginPage enterUsername(String username) {
        findElement(usernameFiled).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        findElement(passwordFiled).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        findElement(loginbtn).click();
        return this;
    }

    public String getErrorMessage() {
        return findElement(mgserror).getText();
    }
}