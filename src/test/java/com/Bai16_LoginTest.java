package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import com.utils.BasicTest;
import com.utils.Utils;


public class Bai16_LoginTest extends BasicTest {


    @Test(priority = 1)
    public void loginTestSuccess() throws Exception {
        // Mở trang đăng nhập
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Nhập email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='username']"));
        emailInput.sendKeys("huadongxuan852@gmail.com");

        //Nhập password
         WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
         passwordInput.sendKeys("xuanice123");

         //Click nút đăng nhập
        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait(3000);

        // Kiểm tra đăng nhập thành công
        boolean isLoginDisplay  = isElementDisplayed(loginBtn);
        Assert.assertFalse(isLoginDisplay);
        Utils.hardWait(3000);

    }


   @Test(priority = 2)
    public void loginTestFailed() throws Exception{
         // Mở trang đăng nhập
        String url ="https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        //Nhập email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='username']"));
        emailInput.sendKeys("huadongxuan852@gmail.com");

        //Bỏ trống password
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInput.click();
        
        //Click đăng nhập
        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait(3000);

        // Kiểm tra lỗi
         WebElement errorrMessageText = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"));
        Assert.assertTrue(errorrMessageText.isDisplayed());

    }

    public boolean isElementDisplayed(WebElement element){

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        
    }

}

