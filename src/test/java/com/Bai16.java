package com;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
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
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //WebElement email = driver.findElement(By.id("reg_email"));
        //WebElement password = driver.findElement(By.id("reg_password"));
        WebElement registerButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        registerButton.click();
        WebElement errorElement = driver.findElement(By.xpath("//*[text()=' Vui lòng cung cấp địa chỉ email hợp lệ.\t\t']"));
        String errorMessage = errorElement.getText();
        System.out.println(errorMessage);
        assert errorMessage.contains("Vui lòng cung cấp địa chỉ email hợp lệ");
        
        WebElement email2 = driver.findElement(By.xpath("//input[@id='reg_email']"));
        email2.sendKeys("123@456");
        WebElement registerButton2 = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        registerButton2.click();
        WebElement errorElement3 = driver.findElement(By.xpath("//*[text()=' Vui lòng cung cấp địa chỉ email hợp lệ.\t\t']"));
        String errorMessage3 = errorElement3.getText();
        System.out.println(errorMessage3);
        assert errorMessage3.contains("Vui lòng cung cấp địa chỉ email hợp lệ");

        WebElement email3 = driver.findElement(By.xpath("//input[@id='reg_email']"));
        email3.clear();
        email3.sendKeys("qwerty@gmail.com");
        WebElement registerButton3 = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        registerButton3.click();
        WebElement errorElement2 = driver.findElement(By.xpath("//*[text()=' Vui lòng nhập mật khẩu tài khoản.\t\t']"));
        String errorMessage2 = errorElement2.getText();
        System.out.println(errorMessage2);
        assert errorMessage2.contains(" Vui lòng nhập mật khẩu tài khoản.");
        // password.sendKeys("");
        // loginButton.click();
    }

    // public static void main(String[] args) throws Exception {
    //     Bai16 test = new Bai16();
    //     test.loginTest();
    // }
}
