package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_RegisterTest extends BasicTest {


    @Test()
    public void registerTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        Utils.hardWait(); // cho 3s

        // enter username
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("test@gmail.com");

        Utils.hardWait(); // cho 3s

        // enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("testtest");

        Utils.hardWait(); // cho 3s

        // click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        Utils.hardWait(); // cho 3s

        // verify login success
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertEquals(errorMessage.getText(), "");
    }

}
