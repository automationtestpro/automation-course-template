package com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.config.Constants;
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

        // Launch website
        String url = Constants.URL; // Use the URL from Constants class
        driver.get(url);

        //Enter Email

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys(username);
        // WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        // emailField.sendKeys(username);
        // Utils.hardWait(1000); // Wait for 1 second to simulate user typing

        //Enter Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys(password);
        // WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        // passwordField.sendKeys(password);
        // Utils.hardWait(1000); //


        //Click Login Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='login']"))).click();
        // WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        // loginButton.click();
        // Utils.hardWait(3000); //


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='alert']")));


        Assert.assertEquals(isErrorMessageDisplayed(), expectedErrormessage, "Error message does not match." + expectedErrormessage);



    }


    public String isErrorMessageDisplayed() {
        try {
            // Check if the error message element is present
            WebElement errorMessage = driver.findElement(By.xpath("//ul[@role='alert']"));
            return errorMessage.getText();
        } catch (Exception e) {
            // If an exception occurs, it means the error message is not displayed
            return "";
        }
    }


    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        return new Object[][] {
            {"testtest@gmail.com" , "test1234", "Lỗi: Mật khẩu bạn nhập cho địa chỉ email testtest@gmail.com không đúng. Bạn quên mật khẩu?a"}, // Invalid credentials
            // {"duykhanhrc@gmail.com", "123456", ""},
            // {"duykhanhrc@gmail.com", "", "Lỗi: Mục nhập mật khẩu trống."},
            // {"", "123456", "Lỗi: Yêu cầu tên tài khoản."},
            // {"duykhanhrc", "1", "Lỗi: Mật khẩu mà bạn đã nhập cho người dùng duykhanhrc chưa đúng. Bạn quên mật khẩu?"},
        };
    }
}
