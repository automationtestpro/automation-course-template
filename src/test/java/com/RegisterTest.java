package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest extends BasicTest {


    @Test()
    public void loginTest()  {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        WebElement emailEle = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        emailEle.sendKeys("testtest@gmail.com");

        // Pass
        WebElement passEle = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passEle.sendKeys("testtest");

        // Login
        WebElement loginEle = driver.findElement(By.xpath("(//*[contains(text(),\"Đăng nhập\")])[4]"));
        loginEle.click();

        Utils.hardWait(); // 3s


        Assert.assertFalse(loginEle.isDisplayed());

    }

}
