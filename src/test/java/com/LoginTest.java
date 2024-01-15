package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BasicTest {

    @Test(priority = 2)
    public void zoginTest() throws Exception {

    }


    @Test(priority = 1)
    public void loginTest() throws Exception {

        // // Chromedriver path
        // // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // // ChromeOptions options = new ChromeOptions();
        // // System.setProperty("webdriver.chrome.driver", driverPath);
        // // driver = new ChromeDriver(options);
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        // // Maximize the browser
        // driver.manage().window().maximize();
        // //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        WebElement userEle = driver.findElement(By.xpath("//input[@id=\"username\"]"));

        userEle.sendKeys("testtest@gmail.com");



        // Enter password


        WebElement passEle = driver.findElement(By.xpath("//input[@id=\"password\"]"));

        passEle.sendKeys("testtest");

        // Click login
        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();


        // Verify login success
        Assert.assertFalse(loginBtn.isDisplayed()); // Make sure button login is not displayed



        Utils.hardWait(5000); // 5s

        // driver.quit();
    }

}
