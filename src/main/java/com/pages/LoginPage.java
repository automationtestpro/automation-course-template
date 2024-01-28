package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    protected WebDriver driver;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By tkBtn = By.id("UserLogin");
    By email = By.xpath("//input[@name=\"EmailPhoneDN\"]");
    By dnBtn = By.xpath("//*[@class=\"btn-login-wrap\"]");
    By pw = By.name("PasswordDN");
    By loginSubmitBtn = By.xpath("//button[contains(@class,\"btn btn-login col-xs-12\") and text() = \"Đăng nhập\"]");

    public void clickTKBtn() {
        waitAndFind(tkBtn).click();
    }

    public void clickDNBtn() {
        waitAndFind(dnBtn).click();
    }

    public void sendEmail(String value) {
        waitAndFind(email).sendKeys(value);
    }

    public void sendPw(String value) {
        waitAndFind(pw).sendKeys(value);
    }

    public void clickSubmitLogin() {
        findElementByLocator(loginSubmitBtn);
    }



}