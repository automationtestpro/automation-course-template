package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver givenDriver) { // constructor
        super(givenDriver);
    }

    // Locators
    private By usernameField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@name='login']");
    private By errorMessage = By.xpath("//ul[@class='woocommerce-error']");

    // Methods
    public void enterUsername(String username) {
        findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return findElement(errorMessage).getText();
    }
    
}
