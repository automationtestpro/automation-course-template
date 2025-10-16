package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_LoginTest extends BasicTest {
//Nhập đủ mail và password
    //Truy cập url
    @Test(priority = 1)
    public void loginTestSuccess() throws Exception {
        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");

        //Nhập mail
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("testtest@gmail.com");

        //Nhập pass
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("1234");

        //Click button login
        WebElement loginBtn = driver.findElement(By.name("login"));
        loginBtn.click();

        Utils.hardWait(3000);
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Địa chỉ email không xác định");
    }

    // Không nhập pass
    @Test(priority = 2)
    public void loginTestFailed() throws Exception {
        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("testtest@gmail.com");

        // không nhập
        WebElement password = driver.findElement(By.id("password"));
        password.clear(); 

        WebElement loginBtn = driver.findElement(By.name("login"));
        loginBtn.click();

        Utils.hardWait(3000);

        WebElement errorMsg = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Mục nhập mật khẩu trống");
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
