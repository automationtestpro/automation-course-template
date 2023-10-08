package com;

import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;



public class LoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement submitButton = driver.findElement(By.xpath("//button[@name='register']"));
        submitButton.click();

        String expectEmailError ="Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        WebElement errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='alert']//li")));
        String emptyEmailErrorText = errorText.getText();
        Assert.assertEquals(emptyEmailErrorText,expectEmailError);

        WebElement emailInput = driver.findElement(By.id("reg_email"));
        emailInput.sendKeys("123$456");

        submitButton = driver.findElement(By.xpath("//button[@name='register']"));
        submitButton.click();

        errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='alert']//li")));
        String invalidEmailErrorText = errorText.getText();
        Assert.assertEquals(invalidEmailErrorText,expectEmailError);

        emailInput.clear();
        emailInput.sendKeys("khoa@gmail.com");

        submitButton = driver.findElement(By.xpath("//button[@name='register']"));
        submitButton.click();

        String expectedBlankPassError ="Lỗi: Vui lòng nhập mật khẩu tài khoản.";
        errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='alert']//li")));
        String validEmailErrorText = errorText.getText();
        Assert.assertEquals(validEmailErrorText,expectedBlankPassError);
    }
}
