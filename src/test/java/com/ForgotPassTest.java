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

import com.utils.BasicTest;
import com.utils.Utils;

public class ForgotPassTest extends BasicTest {


    @Test()
    public void exampleTest() throws Exception {

        WebDriver driver = threadLocalDriver.get();

        // Launch website
        String url = "https://the-internet.herokuapp.com/forgot_password";
        driver.get(url);
        Utils.hardWait();

        // Enter email address
        WebElement emailField = driver.findElement(By.id("email"));
        Utils.hardWait();
        
        


        
























        
    }

}
