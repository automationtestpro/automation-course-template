package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai16 extends BasicTest {
    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Click Submit button
        WebElement btnRegister = driver.findElement(By.xpath("//button[@name=\"register\"]"));
        btnRegister.click();
        WebElement noticeString = driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]"));
        Assert.assertTrue(noticeString.getText().contains("Vui lòng cung cấp địa chỉ email hợp lệ"));

        //Dien email invalid
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='reg_email']"));
        inputEmail.sendKeys("abc@xyz");
        WebElement btnRegister2 = driver.findElement(By.xpath("//button[@name=\"register\"]"));
        btnRegister2.click();
        WebElement noticeString2 = driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]"));
        Assert.assertTrue(noticeString2.getText().contains("Vui lòng cung cấp địa chỉ email hợp lệ"));


        //Dien email hop le
        WebElement inputEmail2 = driver.findElement(By.xpath("//input[@id='reg_email']"));
        inputEmail2.clear();
        inputEmail2.sendKeys("trangtq@behemoth.vn");
        WebElement btnRegister3 = driver.findElement(By.xpath("//button[@name=\"register\"]"));
        btnRegister3.click();
        WebElement noticeString3 = driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]"));
        Assert.assertTrue(noticeString3.getText().contains("Vui lòng nhập mật khẩu tài khoản"));
    }
}
