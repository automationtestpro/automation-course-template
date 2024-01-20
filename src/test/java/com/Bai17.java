package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai17 extends BasicTest {


    @Test()
    public void bai17() throws Exception {
        // Log in
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("nhatthuyip@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Bgr2ftvvYsY8hVe");
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();

        // Log out
        WebElement thoat = driver.findElement(By.xpath("//a[normalize-space()='Thoát']"));
        thoat.click();

        // Back page
        driver.navigate().back();

        // Verirfy can not visit account page 
        WebElement loginbtn = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        Assert.assertTrue(loginbtn.isDisplayed());



    }

}