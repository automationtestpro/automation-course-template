package com;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {

    public void ClickRegisterBtn() {
        WebElement registerBtn = driver.findElement(By.xpath("//*[@name='register']"));
        registerBtn.click();
        Utils.hardWait();
    }

    public void ClickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.xpath("//*[@name='login']"));
        loginBtn.click();
        Utils.hardWait();
    }

    public void verifyTextRegisterAndEmailInvalid(){
        WebElement message = driver.findElement(By.xpath("//*[text()=' Vui lòng cung cấp địa chỉ email hợp lệ.\t\t']"));
        String actual = message.getText().trim();
        String expected = "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(expected,actual);
        Utils.hardWait();
    }

    @Test(enabled=true)
    public void loginTestBai16() {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Homework 16
        // Case register
        ClickRegisterBtn();
        verifyTextRegisterAndEmailInvalid();

        // Case emailInvalid
        WebElement emailEle1 = driver.findElement(By.id("reg_email"));
        emailEle1.sendKeys("123@456");
        ClickRegisterBtn();
        // Verify emailInvalid
        verifyTextRegisterAndEmailInvalid();
        Utils.hardWait();
        
        // Case emailValid
        WebElement emailEle2 = driver.findElement(By.id("reg_email"));
        emailEle2.clear();
        emailEle2.sendKeys("qwerty@gmail.com");
        ClickRegisterBtn();
        // Verify emailValid
        WebElement messageEmailValid = driver.findElement(By.xpath("//*[text()=' Vui lòng nhập mật khẩu tài khoản.\t\t']"));
        String actualEmailValid = messageEmailValid.getText().trim();
        String expectedEmailValid = "Lỗi: Vui lòng nhập mật khẩu tài khoản.";
        Assert.assertEquals(expectedEmailValid,actualEmailValid);

    }

    @Test(enabled=true)
    public void loginTestBai17() {

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Homework 17
        //Case Login
        WebElement userNameEle = driver.findElement(By.xpath("//*[@name='username']"));
        userNameEle.sendKeys("huou@gmail.com");

        WebElement passEle = driver.findElement(By.xpath("//*[@name='password']"));
        passEle.sendKeys("Huou123@123");
        ClickLoginBtn();

        WebElement exitEle = driver.findElement(By.xpath("//*[text()='Thoát']"));
        Actions action = new Actions(driver);
        action.moveToElement(exitEle).click(exitEle).build().perform();
        Utils.hardWait();
        action.sendKeys(Keys.RETURN);
        action.perform();
        Utils.hardWait();
        WebElement textRegister = driver.findElement(By.xpath("//h2[text()='Đăng ký']"));
        Assert.assertTrue(textRegister.isDisplayed());

    }

    @Test(enabled=true)
    public void loginTestBai18() {

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Homework 18
        //Case Login
        WebElement userNameEle = driver.findElement(By.xpath("//*[@name='username']"));
        userNameEle.sendKeys("huou@gmail.com");

        WebElement passEle = driver.findElement(By.xpath("//*[@name='password']"));
        passEle.sendKeys("Huou123@123");
        ClickLoginBtn();

        //cach 1
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");  
        //Switch focus to new tab
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles()); 
        driver.switchTo().window(tabs.get(0));
        //Launch URL in the new tab
        driver.get("https://bantheme.xyz/hathanhauto/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/");

    }
    


}
