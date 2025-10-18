package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
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
        WebElement emailInp = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailInp.sendKeys("testtest@gmail.com");

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passwordInp.sendKeys("");

        // Click login button
        WebElement RegisBtn = driver.findElement(By.xpath("//button[@name='register']"));
        RegisBtn.click();

        // Add a small wait to ensure the element is not displayed anymore
        //Utils.hardWait(2000);
        //boolean isRegisDiplay = isElementDisplayed(RegisBtn);
        //Assert.assertTrue(isRegisDiplay);
    

        Utils.hardWait(5000);

        //check Register fail
        WebElement errorRegisMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        String errorRegisMessageText = errorRegisMessage.getText();
        System.out.println("Error Message: " + errorRegisMessageText);
        Assert.assertTrue(errorRegisMessageText.contains("An account is already registered with your email address."));   
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
}