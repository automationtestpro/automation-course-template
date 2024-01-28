package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai17 extends BasicTest {
    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        
    // Log in
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

    // Click on 'Tai khoan'
        WebElement taiKhoan = driver.findElement(By.xpath("//a[@class='pos-login']"));
        taiKhoan.click();
    // Click log-out
        WebElement btnLogout = driver.findElement(By.xpath("//a[contains(text(),'Thoát')]"));
        btnLogout.click();
    // Click on Back button
        driver.navigate().back();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@name='login']")).isDisplayed());
    }
}
