package com;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_LoginTest1 extends BasicTest {
    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys("mdangdn29@gmail.com");;
        //WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys("D@ng291199");

        // Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();

        // Add a small wait to ensure the element is not displayed anymore
       // Utils.hardWait(2000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated()));
        boolean isLoginDisplay = isElementDisplayed(By.xpath("//button[text()='Đăng nhập']"));
        Assert.assertFalse(isLoginDisplay);
    

        //Utils.hardWait(5000);
        //check login fail
        //WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        //String errorMessageText = errorMessage.getText();
        //System.out.println("Error Message: " + errorMessageText);
        //Assert.assertTrue(errorMessageText.contains("Mật khẩu bạn nhập cho địa chỉ email mdangdn29@gmail.com không đúng"));   
    }
   
    //@Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username
        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys("mdangdn29@gmail.com");

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys("");

        // Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();

        // Add a small wait to ensure the element is not displayed anymore
        //Utils.hardWait(2000);
        //boolean isLoginDisplay = isElementDisplayed(loginBtn);
        //Assert.assertFalse(isLoginDisplay);
    

        Utils.hardWait(5000);

        //check login fail
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        String errorMessageText = errorMessage.getText();
        System.out.println("Error Message: " + errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Mục nhập mật khẩu trống."));   
    }

    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
}