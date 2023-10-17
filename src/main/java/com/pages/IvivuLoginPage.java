package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.Utils;

public class IvivuLoginPage extends BasePage {

    // By tk = By.xpath("//li[@id=\"UserLogin\"]");
    // By dn = By.xpath("(//li[@class=\"btn-login-wrap\"])[1]");
    // By byEmail = By.xpath("//input[@name='EmailPhoneDN']");
    // By byPassword = By.xpath("//input[@name='PasswordDN']");
    // By byLoginBtn = By.xpath("(//button[contains(@class,\"btn-login\")])[1]");


    @FindBy(xpath = "//li[@id=\"UserLogin\"]")
    WebElement tkEle;

    @FindBy(xpath = "(//li[@class=\"btn-login-wrap\"])[1]")
    WebElement dnEle;

    @FindBy(xpath = "//input[@name='EmailPhoneDN']")
    WebElement emailEle;

    @FindBy(xpath = "//input[@name='PasswordDN']")
    WebElement passEle;

    @FindBy(xpath = "(//button[contains(@class,\"btn-login\")])[1]")
    WebElement loginEle;
    
    public IvivuLoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public IvivuLoginPage openDn() {
        //findElement(tk).click();
        tkEle.click();
        Utils.hardWait();
        //findElement(dn).click();
        dnEle.click();
        Utils.hardWait();

        return this;
    }
    
    public IvivuLoginPage enterEmail(String emailString) {
        System.out.println("here1");
        //WebElement email = findElement(byEmail);
        System.out.println("here2");
        emailEle.sendKeys(emailString);

        return this;
    }

    public IvivuLoginPage enterPass(String passString) {
        //WebElement pass = findElement(byPassword);
        passEle.sendKeys(passString);

        return this;
    }

    public IvivuLoginPage clickLogin() {
        //WebElement loginBtn = findElement(byLoginBtn);
        loginEle.click();

        return this;
    }
    
    
}
