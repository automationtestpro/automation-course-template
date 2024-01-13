package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        //Step1: Click  submit button
        WebElement submitBtn = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        submitBtn.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='main']//li[1]"));
        System.out.println(errorMessage.getText());
        Assert.assertEquals(errorMessage.getText(),"Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");

        //Step2: Email invalid
        WebElement email = driver.findElement(By.xpath("//input[@id='reg_email']"));
        email.sendKeys("123@456");
        WebElement submitBtn2 = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        submitBtn2.click();
        WebElement errorMessage2 = driver.findElement(By.xpath("//div[@id='main']//li[1]"));
        Assert.assertEquals(errorMessage2.getText(),"Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");


        //Step3:Valid email, missing password
        WebElement email3 = driver.findElement(By.xpath("//input[@id='reg_email']"));
        email3.clear();
        email3.sendKeys("thuytran@gmail.com");
        WebElement submitBtn3 = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        submitBtn3.click();
        WebElement errorMessage3 = driver.findElement(By.xpath("//div[@id='main']//li[1]"));
        Assert.assertEquals(errorMessage3.getText(),"Lỗi: Vui lòng nhập mật khẩu tài khoản.");

        //QUESTION: khong biet sao mỗi lần e lại phải khai báo lại biến email, buttonb, error nếu không chạy sẽ báo lỗi không tìm thấy phần tủ.tủ
       // theo lí thuyết là không cần khai báo lại nữa nhưng không khai báo thêm thì nó sẽ bị lỗi ý


    }

}
