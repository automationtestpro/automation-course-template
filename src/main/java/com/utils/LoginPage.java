package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage extends BasicTest {


    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(),'Xin chào')]")
    private WebElement welcomeText;

     public LoginPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url); 
        Assert.assertEquals(driver.getCurrentUrl(), url, "Không mở đúng trang đăng nhập!");
        return this;
    }

    public LoginPage login(String userName, String password) {
        waitForElementVisible(usernameInput).clear();
        usernameInput.sendKeys(userName);

        waitForElementVisible(passwordInput).clear();
        passwordInput.sendKeys(password);
        
        waitForElementClickable(loginButton).click();
        return this;
    }

    public LoginPage verifyLoginSuccess() {
        Assert.assertTrue(waitForElementVisible(welcomeText).isDisplayed());
        System.out.println("Đăng nhập thành công");
        return this;
    }
}