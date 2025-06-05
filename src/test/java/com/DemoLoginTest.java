package com;

import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DemoLoginTest extends BasicTest {
    
    
    
    @Test()
    public void loginTestErrorMessage() throws Exception {
        // WebDriverManager.chromedriver().setup(); // Setup WebDriverManager for ChromeDriver
        // WebDriver driver = new ChromeDriver(); // Initialize your WebDriver here

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);

        //Enter Email
        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("testtest@gmail.com");
        Utils.hardWait(1000); // Wait for 1 second to simulate user typing

        //Enter Password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("test1234");
        Utils.hardWait(1000); //


        //Click Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();
        Utils.hardWait(3000); //


        //Verify error message
        // WebElement errormessage = driver.findElement(By.xpath("//ul[@role='alert']"));
        // String message = errormessage.getText();
        // Assert.assertTrue(message.contains("Lỗi"));
        Assert.assertTrue(isErrorMessageDisplayed());

        // driver.quit(); // Close the browser


    }


    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);

        //Enter Email
        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("testtest@gmail.com");
        Utils.hardWait(1000); // Wait for 1 second to simulate user typing

        //Enter Password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("testtest");
        Utils.hardWait(1000); //


        //Click Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();
        Utils.hardWait(3000); //


        //Verify error message
        // WebElement errormessage = driver.findElement(By.xpath("//ul[@role='alert']"));
        // String message = errormessage.getText();
        // Assert.assertTrue(message.contains("Lỗi"));

        Assert.assertFalse(isErrorMessageDisplayed());



    }



    public Boolean isErrorMessageDisplayed() {
        try {
            // Check if the error message element is present
            WebElement errorMessage = driver.findElement(By.xpath("//ul[@role='alert']"));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            // If an exception occurs, it means the error message is not displayed
            return false;
        }
    }

}
