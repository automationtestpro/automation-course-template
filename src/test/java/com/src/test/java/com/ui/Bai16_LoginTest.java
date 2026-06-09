package com.src.test.java.com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_LoginTest extends BasicTest {

    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website and navigate to https://bantheme.xyz/hathanhauto/tai-khoan/
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Declare locator
        WebElement loginEmailFieldLocator = driver.findElement(By.id("username"));
        WebElement loginPasswordFieldLocator = driver.findElement(By.id("password"));
        WebElement loginButtonLocator = driver.findElement(By.cssSelector("button[name='login']"));

        // Enter email address into email field
        loginEmailFieldLocator.sendKeys("ntthanhngan.2001@gmail.com");
        // Enter password into password field
        loginPasswordFieldLocator.sendKeys("Thanhngan@123456");
        // Click login button
        loginButtonLocator.click();
        Utils.hardWait(3000);

        // Verify displaying Xin Chào after login successfully
        WebElement contentTextLocator = driver.findElement(By.className("woocommerce-MyAccount-content"));
        Assert.assertTrue(contentTextLocator.getText()
                .contains("Xin chào"));



                List<WebElement> accountInfoLocator = driver.findElements(By.cssSelector("div.woocommerce-MyAccount-content p"));


                for (WebElement element : accountInfoLocator) {
                    String elementText = element.getText();
                    if (elementText.contains("Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class")) {
                        // Perform actions or assertions if the element contains the specified text
                        element.click(); // Example action: click the element
                    }
                }

    }

    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website and navigate to https://bantheme.xyz/hathanhauto/tai-khoan/
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Declare locator
        WebElement loginEmailFieldLocator = driver.findElement(By.id("username"));
        WebElement loginPasswordFieldLocator = driver.findElement(By.id("password"));
        WebElement loginButtonLocator = driver.findElement(By.cssSelector("button[name='login']"));

        // Enter email address into email field
        loginEmailFieldLocator.sendKeys("ntthanhngan.2001@gmail.com");
        // Do not enter password into password field
        // Click login button
        loginButtonLocator.click();
        Utils.hardWait(3000);

        // Get the error message
        WebElement errorMessageLocator = driver.findElement(By.cssSelector("ul[role=\"alert\"] li"));
        String errorMessage = errorMessageLocator.getText();
        // Verify the error mesage display Mục nhập mật khẩu trống
        Assert.assertTrue(errorMessage
                .contains("Mục nhập mật khẩu trống"));
    }

}