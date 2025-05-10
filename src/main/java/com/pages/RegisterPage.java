package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {
    
    public RegisterPage(WebDriver givenDriver) { // constructor
        super(givenDriver);
    }

    // Locators
    private By usernameRegister=By.xpath("//input[@id='reg_email']");
    private By passwordRegister=By.xpath("//input[@id='c']");
    private By registerbtn=By.xpath("//button[@class='woocommerce-Button woocommerce-button button woocommerce-form-register__submit']");
    private By mgserrorregister=By.xpath("//ul[@class='woocommerce-error']//li");

    // Methods
    public RegisterPage enterUsername(String username) {
        findElement(usernameRegister).sendKeys(username);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        findElement(passwordRegister).sendKeys(password);
        return this;
    }

    public RegisterPage clickRegisterButton() {
        findElement(registerbtn).click();
        return this;
    }

    public String getErrorMessage() {
        return findElement(mgserrorregister).getText();
    }
}