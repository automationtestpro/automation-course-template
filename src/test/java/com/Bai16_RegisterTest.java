package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_RegisterTest extends BasicTest {

    @Test()
    public void registerTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='reg_email']"))).sendKeys("testtest@gmail.com");
       

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passwordInp.sendKeys("");

        // Click login button
        WebElement RegisBtn = driver.findElement(By.xpath("//button[@name='register']"));
        RegisBtn.click();
            
        //check Register fail
        WebElement errorRegisMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='woocommerce-error']")));
        String errorRegisMessageText = errorRegisMessage.getText();
        System.out.println("Error Message: " + errorRegisMessageText);
        Assert.assertTrue(errorRegisMessageText.contains("An account is already registered with your email address."));   
    }

    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
}