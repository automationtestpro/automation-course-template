package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver givenDriver) { // constructor
        super(givenDriver);
    }

    // Locators
    private By usernameField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@name='login']");
    private By errorMessage = By.xpath("//ul[@class='woocommerce-error']");


    // @FindBy(xpath = "//input[@id='username']")
    // private WebElement usernameFieldElement;

    // Methods
    public LoginPage enterUsername(String username) {
        findElement(usernameField).sendKeys(username);
        // usernameFieldElement.sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {
        findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        findElement(loginButton).click();
        return this;
    }

    public String getErrorMessage() {
        return findElement(errorMessage).getText();
    }
    
}
