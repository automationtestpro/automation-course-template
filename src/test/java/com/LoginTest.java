package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // enter username
        loginPage.enterUsername("test@gmail.com");

        // enter password
        loginPage.enterPassword("testtest");

        // click login button
        loginPage.clickLoginButton();

        // verify login success
        String message = loginPage.getErrorMessage();
        // Assert.assertEquals(message, "");


        // homepage
        homePage.open();
        Boolean result = homePage.isNewProductSectionDisplay();

        Assert.assertTrue(result, "New product section is not displayed");
    }

}
