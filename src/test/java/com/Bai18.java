package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai18 extends BasicTest {

    @Test()
    public void bai18() throws Exception {
        // Log in
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("nhatthuyip@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Bgr2ftvvYsY8hVe");
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();

        // Get the current tab
        String firstTabHandle = driver.getWindowHandle();

        // Open a new tab using JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open();");

        // Switch new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String url1 = "https://bantheme.xyz/hathanhauto";
        driver.get(url1);
        // Get the current tab
        String secondTabHandle = driver.getWindowHandle();

        // Switch back to the first tab using the saved window handle
        driver.switchTo().window(firstTabHandle);
        // close the previous tab
        driver.close();

        // Switch to new tab and log in
        driver.switchTo().window(secondTabHandle);
        WebElement loginbtn = driver.findElement(By.xpath("//a[@class='pos-login']"));
        loginbtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/tai-khoan/");

    }

}
