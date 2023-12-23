package com;

import com.utils.BasicTest;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Bai16 extends BasicTest {

    @Test()
    public void bai16() {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //TC1: click  submit button
        WebElement submitBtn = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        submitBtn.click();
        WebElement textInfo = driver.findElement(By.xpath("//div[@id='main']//li[1]"));
        System.out.println(textInfo.getText());
        Assert.assertEquals(textInfo.getText(),"Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");

        //TC2: Email invalid
        WebElement reg_email = driver.findElement(By.xpath("//input[@id='reg_email']"));
        reg_email.sendKeys("//input[@id='reg_email']");
        submitBtn.click();
        System.out.println(textInfo.getText());
        Assert.assertEquals(textInfo.getText(),"Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");

        //TC3:Valid email, missing password
        reg_email.sendKeys("son.tran@gmail.com");
        submitBtn.click();
        System.out.println(textInfo.getText());
        Assert.assertEquals(textInfo.getText(),"Lỗi: Vui lòng nhập mật khẩu tài khoản.");





    }
}
