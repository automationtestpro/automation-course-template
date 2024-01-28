package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai22 extends BasicTest {
    @Test()
    public void loginTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

       // Click Log in button

        loginPage.clickTKBtn();
        loginPage.clickDNBtn();
        loginPage.sendEmail("trangtq.9593@gmail.com");
        loginPage.clickSubmitLogin();

      //Get html5 message
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement password = driver.findElement(By.name("PasswordDN"));
        String message = (String)js.executeScript("return arguments[0].validationMessage;", password);
      
        //Verify test case
        Assert.assertEquals(message, "Please fill out this field.");

        loginPage.sendPw("12341234");
        loginPage.clickSubmitLogin();

        //Verify test case
        Assert.assertTrue(
            driver.findElement(
                By.xpath("//button[contains(@class,\"col-xs-12 logout-btn\") and text() = \"Đăng xuất\"]")
                ).isEnabled());




    }
    
}
