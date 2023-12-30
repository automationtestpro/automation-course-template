package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai18 extends BasicTest {
    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);

        // Log in and go to home page
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='username']"));
        inputEmail.clear();
        inputEmail.sendKeys("trangtq.9593@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.clear();
        inputPassword.sendKeys("Quynhtrang");
        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
        btnLogin.click();
        String homepage = "https://bantheme.xyz/hathanhauto/";
        driver.get(homepage);
        String originalWindow = driver.getWindowHandle();

        //Open New Tab
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open()");

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String newWindow = driver.getWindowHandle();
        //Go to homepage in new tab
        driver.get(homepage);
        
        
        //Close old tab
        driver.switchTo().window(originalWindow);
        driver.close();
        driver.switchTo().window(newWindow);
        // Click on 'Dang Nhap'
        WebElement btnDangNhap = driver.findElement(By.xpath("//a[@class='pos-login']"));
        btnDangNhap.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/tai-khoan/");

    }
}
