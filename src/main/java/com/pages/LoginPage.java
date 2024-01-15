package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    protected WebDriver driver;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //By email = By.xpath("//input[@name=\"EmailPhoneDN\"]");

    @FindBy(xpath = "//input[@name=\"EmailPhoneDN\"]")
    private WebElement email;

    @FindBy(xpath = "//input[@name=\"PasswordDN\"]")
    private WebElement password;

    @FindBy(xpath = "(//*[text()='Đăng nhập'])[3]")
    private WebElement loginBtn;


    public LoginPage sendEmail(String value) {
        //findElementByLocator(email).sendKeys(value);
        email.clear();
        email.sendKeys(value);

        return this;
    }

    public LoginPage sendPass(String value) {
        password.clear();
        password.sendKeys(value);

        return this;
    }

    public LoginPage login() {
        loginBtn.click();

        return this;
    }
}
