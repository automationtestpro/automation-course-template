package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {

    public void ClickRegisterBtn () {
        WebElement registerBtn = driver.findElement(By.xpath("//*[@name='register']"));
        registerBtn.click();
        Utils.hardWait();
    }

    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Homework 16
        // Case register
        ClickRegisterBtn();
        WebElement messageRegister = driver.findElement(By.xpath("//*[text()=' Vui lòng cung cấp địa chỉ email hợp lệ.\t\t']"));
        String actualRegister = messageRegister.getText().trim();
        String expectedRegister = "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(expectedRegister,actualRegister);
        Utils.hardWait();

        // Case emailInvalid
        WebElement emailEle1 = driver.findElement(By.id("reg_email"));
        emailEle1.sendKeys("123@456");
        ClickRegisterBtn();
        // Verify emailInvalid
        WebElement messageEmailInValid = driver.findElement(By.xpath("//*[text()=' Vui lòng cung cấp địa chỉ email hợp lệ.\t\t']"));
        String actualEmailInValid = messageEmailInValid.getText().trim();
        String expectedEmailInValid = "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(expectedEmailInValid,actualEmailInValid);
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



}
