package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    // By byEmailField = By.xpath("//input[@id='username']");
    // By byPassField = By.xpath("//input[@id='password']");
    // By byLoginButton = By.xpath("//button[@name='login']");
    // By byErrorMessage = By.xpath("//ul[@class='woocommerce-error']");

    @FindBy(xpath = "//input[@id='username']") 
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passField;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;


    public void login(String email, String password) {
        // Enter email
        // WebElement emailField = driver.findElement(byEmailField);
        emailField.sendKeys(email);

        // Enter password
        // WebElement passField = driver.findElement(byPassField);
        passField.sendKeys(password);

        // Click on Login button
        // WebElement loginButton = driver.findElement(byLoginButton);
        loginButton.click();
    }

    public LoginPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
