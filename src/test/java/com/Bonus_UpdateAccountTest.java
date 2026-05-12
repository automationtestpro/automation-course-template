package com;

import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bonus_UpdateAccountTest extends BasicTest {

    @Test()
    public void updateAccountSuccessfullyTest() throws Exception {
        // Launch website and navigate to https://bantheme.xyz/hathanhauto/tai-khoan/
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        String originalEmail = "ntthanhngan.2001@gmail.com";
        String originalPass = "Thanhngan@123456";
        // String originalDisplayName = "ntthanhngan.2001";

        String newEmail = "ntthanhngan.2001.updated@gmail.com";
        // String newDisplayName = "ntthanhngan.2001_updated";

        // Login
        // WebElement loginEmailFieldLocator = driver.findElement(By.id("username"));
        // WebElement loginPasswordFieldLocator = driver.findElement(By.id("password"));
        // WebElement loginButtonLocator = driver.findElement(By.cssSelector("button[name='login']"));

        // loginEmailFieldLocator.sendKeys("ntthanhngan.2001@gmail.com");
        // loginPasswordFieldLocator.sendKeys("Thanhngan@123456");
        // loginButtonLocator.click();
        login(originalEmail, originalPass);

        WebElement contentTextLocator = driver.findElement(By.className("woocommerce-MyAccount-content"));
        Assert.assertTrue(contentTextLocator.getText()
                .contains("Xin chào")); // login successfully

        // Navigate to the Update account
        driver.findElement(By.cssSelector("a[href*='edit-account']")).click();
        // Navigate to the DisplayName field
        WebElement displayNameFieldLocator = driver.findElement(By.name("account_display_name"));


        // get original display name
        String originalDisplayName = displayNameFieldLocator.getAttribute("value");
        String newDisplayName = originalDisplayName + "_updated";

        displayNameFieldLocator.clear();
        displayNameFieldLocator.sendKeys(newDisplayName);
        // Navigate to the Email field
        WebElement emailAccountFieldLocator = driver.findElement(By.name("account_email"));
        emailAccountFieldLocator.clear();
        emailAccountFieldLocator.sendKeys(newEmail);
        // Save the updates
        driver.findElement(By.name("save_account_details")).click(); // SUCCESS
        Utils.hardWait();
        // Verify the success message
        WebElement alertMessageLocator = driver.findElement(By.className("woocommerce-message"));
        Assert.assertTrue(alertMessageLocator.getText().contains("Thông tin tài khoản đã được cập nhật"));



        // Verify the new email and display name are updated successfully
            
        Assert.assertEquals(displayNameAccountLocator.getText(), newDisplayName); //-> FAILED


        


    }

    @AfterMethod
    public void revertAccountInfo() throws Exception {
        // revert original email
         WebElement emailAccountFieldLocator = driver.findElement(By.name("account_email"));
        emailAccountFieldLocator.clear();
        emailAccountFieldLocator.sendKeys(originalEmail);


        // revert original display name
        WebElement displayNameAccountLocator = driver.findElement(By.cssSelector("p strong"));
        displayNameFieldLocator.clear();
        displayNameFieldLocator.sendKeys(originalDisplayName);
        driver.findElement(By.name("save_account_details")).click();
        Utils.hardWait();
        Assert.assertTrue(alertMessageLocator.getText().contains("Thông tin tài khoản đã được cập nhật"));
    }

    

}