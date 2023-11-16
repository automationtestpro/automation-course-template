package com;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class bai16 extends BasicTest {
    
    @Test()
    public void signupTest() {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //WebElement pwdField = driver.findElement(By.xpath("//*[@id='reg_password']"));

        // Test case 1: sigin without email and pwd
        clickAndCheckAlert(driver, " Vui lòng cung cấp địa chỉ email hợp lệ.\t\t");

        // Test case 2: sigin with invalid email
        WebElement emailField = driver.findElement(By.xpath("//*[@id='reg_email']"));
        emailField.sendKeys("123@456");
        clickAndCheckAlert(driver," Vui lòng cung cấp địa chỉ email hợp lệ.\t\t");        

        // Test case 3: sigin with valid email and no password
        WebElement emailField_2 = driver.findElement(By.xpath("//*[@id='reg_email']"));
        emailField_2.clear();
        emailField_2.sendKeys("qwerty@gmail.com");
        clickAndCheckAlert(driver," Vui lòng nhập mật khẩu tài khoản.\t\t");        

        driver.quit();
    }

    private static void clickAndCheckAlert(WebDriver driver, String searchText) {
        WebElement regButton = driver.findElement(By.xpath("//button[@name='register']"));
        regButton.click();
        try {
            WebElement alertElement = driver.findElement(By.xpath("//*[@role='alert']//*[text()='"+ searchText+"'] "));
            System.out.println("Element found: " + alertElement);
            Assert.assertNotNull(alertElement, "Alert element not found");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Element not found");
            Assert.fail("Alert element not found");
        }
    }

}
