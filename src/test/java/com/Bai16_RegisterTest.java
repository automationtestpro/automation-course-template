package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_RegisterTest extends BasicTest {

    @Test()
    public void registerTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        // driver.get(url);
        // Assert.assertEquals(driver.getCurrentUrl(), url);
        loginPage.open(url);

        loginPage.fillRegEmail("testtest@gmail.com")
                 .fillRegPass("testpassword")
                 .clickRegisterButton();

        String errorRegisMessageText = loginPage.getErrorMessage();

        System.out.println("Error Message: " + errorRegisMessageText);
        Assert.assertTrue(errorRegisMessageText.contains("An account is already registered with your email address."));   
    }

    // public boolean isElementDisplayed(WebElement element){
    //     try {
    //         return element.isDisplayed();
    //     } catch (Exception e) {
    //         return false;// TODO: handle exception
    //     }
    // }
}