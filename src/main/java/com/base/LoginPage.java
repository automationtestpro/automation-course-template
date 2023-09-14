package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private By accountLogin = By.xpath("(//div[@class='img-wrapper'])[1]");
    private By loginBtn = By.xpath("//li[@class='btn-login-wrap']//btn[text()='Đăng nhập']");
    private By emailTxt = By.xpath("//input[@name='EmailPhoneDN']");
    private By passwordTxt = By.xpath("//input[@name='PasswordDN']");
    private By dangNhapBtn = By.xpath("//button[@type='submit'][contains(text(),'Đăng nhập')]");
    private By userNameAfterLogin = By.xpath("//span[@class='username-header']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickAccount() {
        clickToElement(accountLogin);
    }
    public void clickLoginBtn() {
        clickToElement(loginBtn);
    }

    public void inputEmail(String email) {
        sendKeyToElement(emailTxt,email);
    }
    public void inputPassword(String password) {
        sendKeyToElement(passwordTxt,password);
    }

    public HomePage clickDangNhapBtn() {
        clickToElement(dangNhapBtn);
        return new HomePage(driver);
    }

    public String getErrorMessage() {
     WebElement element = driver.findElement(passwordTxt);
      return   getElementValidationMessage(element);
    }

    public String getUserNameText() {
        return findElementByLocator(userNameAfterLogin).getText();
    }

}
