package com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    // @Test()
    public void loginTest() throws Exception {

        WebDriver driver = threadLocalDriver.get();

        // Launch website
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        Utils.hardWait();

        // Enter username and password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        Utils.hardWait();
        // Click on login button
        loginPage.clickLoginButton();
        Utils.hardWait();
        // Verify successful login
        String message = loginPage.getSuccessMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"), "Login failed!");    
    }

    @Test()
    public void loginTestWithWrongPassword() throws Exception {

        WebDriver driver = threadLocalDriver.get();

        // Launch website
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        Utils.hardWait();

        // Enter username and password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("WrongPassword");
        Utils.hardWait();
        // Click on login button
        loginPage.clickLoginButton();
        Utils.hardWait();
        // Verify unsuccessful login
        String message = loginPage.getErrorMessage();
        Assert.assertTrue(message.contains("Your password is invalid!"), "Login succeeded with wrong password!");    
    }


}
