package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait();

        // Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Utils.hardWait();

        // Enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Utils.hardWait();

        // Click on login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Utils.hardWait();

        // Verify login success
        Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area.')]")).isDisplayed(), "Login failed");
        Utils.hardWait();

    }

}
