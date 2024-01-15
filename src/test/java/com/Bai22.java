package com;

import com.mongodb.util.Util;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.DriverManager;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bai22 extends BasicTest {

    @Test()
    public void bai22() {

        WebDriver driver = DriverManager.getDriver();

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        homePage.openTk()
                .openDn();

        loginPage.sendEmail("testtest@gmail.com")
                .sendPass("testtest")
                .login();

        Utils.hardWait();

    }
}