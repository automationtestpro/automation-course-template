package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import com.utils.BasicTest;
import com.utils.Utils;


public class Bai16_RegisterTest extends BasicTest {

    @Test
    public void registerTest() throws Exception {
        // Mở trang đăng ký
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Nhập email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='username']"));
        emailInput.sendKeys("testtest@gmail.com");

        //Ko nhập password
         WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
         passwordInput.clear();

         //Click nút đăng ký
        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();

        //Chờ một xíu
        Utils.hardWait(3000);

        // Kiểm tra thông báo

        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Vui lòng nhập mật khẩu tài khoản");


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
