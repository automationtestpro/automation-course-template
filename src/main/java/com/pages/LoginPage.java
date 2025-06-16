package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver givenDriver) {
        // Constructor for LoginPage
        super(givenDriver);
    }


    By emailField = By.xpath("//input[@id='username']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@name='login']");
    By errorMessage = By.xpath("//ul[@role='alert']");


    // @FindBy(xpath = "//input[@id='username']")
    // private WebElement emailFieldElement;

    public LoginPage enterEmail(String email) {
        // findElement(emailField).sendKeys(email);
        enterText(emailField, email);

        return this;
    }

    public LoginPage enterPassword(String password) {
        // findElement(passwordField).sendKeys(password);
        enterText(passwordField, password);

        return this;
    }

    public LoginPage clickLoginButton() {
        // findElement(loginButton).click();
        clickElement(loginButton);
        return this;
    }
    
    public String getErrorMessage() {
        waitElementVisible(errorMessage);
        return findElement(errorMessage).getText();
    }

    public String isErrorMessageDisplayed() {
        try {
            // Check if the error message element is present
            waitElementVisible(errorMessage);
            return findElement(errorMessage).getText();
        } catch (Exception e) {
            // If an exception occurs, it means the error message is not displayed
            return "";
        }
    }
    
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

}
