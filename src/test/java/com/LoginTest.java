package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Utils.hardWait(); // cho 3s

        // enter username

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys("test@gmail.com");

        // WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        // username.sendKeys("test@gmail.com");

        // Utils.hardWait(); // cho 3s

        // enter password

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys("testtest");

        // WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        // password.sendKeys("testtest");

        // Utils.hardWait(); // cho 3s

        // click login button

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='login']"))).click();

        // WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        // loginButton.click();

        // Utils.hardWait(); // cho 3s

        // verify login success

        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='woocommerce-error']"))).getText();

        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertEquals(message, "");
    }

}
