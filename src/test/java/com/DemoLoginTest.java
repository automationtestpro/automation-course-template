package com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.config.Constants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DemoLoginTest extends BasicTest {
    
    
    
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedErrormessage) throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Launch website
        String url = Constants.URL; // Use the URL from Constants class
        // driver.get(url);
        loginPage.open(url);

        // //Enter Email

        // loginPage.enterEmail(username);

        // //Enter Password
        // loginPage.enterPassword(password);


        // //Click Login Button
        // loginPage.clickLoginButton();

        // loginPage.login(username, password);

        loginPage.enterEmail(username)
                 .enterPassword(password)
                 .clickLoginButton();

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='alert']")));


        Assert.assertEquals(loginPage.isErrorMessageDisplayed(), expectedErrormessage, "Error message does not match." + expectedErrormessage);



    }


    // public String isErrorMessageDisplayed() {
    //     try {
    //         // Check if the error message element is present
    //         WebElement errorMessage = driver.findElement(By.xpath("//ul[@role='alert']"));
    //         return errorMessage.getText();
    //     } catch (Exception e) {
    //         // If an exception occurs, it means the error message is not displayed
    //         return "";
    //     }
    // }


    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        return new Object[][] {
            {"testtest@gmail.com" , "test1234", "Lỗi: Mật khẩu bạn nhập cho địa chỉ email testtest@gmail.com không đúng. Bạn quên mật khẩu?"}, // Invalid credentials
            // {"duykhanhrc@gmail.com", "123456", ""},
            // {"duykhanhrc@gmail.com", "", "Lỗi: Mục nhập mật khẩu trống."},
            // {"", "123456", "Lỗi: Yêu cầu tên tài khoản."},
            // {"duykhanhrc", "1", "Lỗi: Mật khẩu mà bạn đã nhập cho người dùng duykhanhrc chưa đúng. Bạn quên mật khẩu?"},
        };
    }
}
