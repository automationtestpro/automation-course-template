package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter email
        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("testtest@gmail.com");

        // Enter password
        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        passField.sendKeys("testtest");

        // Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        // Verify login
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertEquals(errorMessage.getText(), "");

    }


    @Test()
    public void loginTestNegative() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter email
        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("testtest123@gmail.com");

        Utils.hardWait(); // 3s

        // Enter password
        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        passField.sendKeys("testtest123");

        Utils.hardWait(); // 3s

        // Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        Utils.hardWait(); // 3s

        // Verify login
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertEquals(errorMessage.getText(), "Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.");

    }

}
