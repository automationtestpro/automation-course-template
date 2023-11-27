package com;

import java.io.File;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.DriverManager;
import com.utils.ExcelUtils;
import com.utils.Utils;

public class Bai20 extends BasicTest {


   
    
    @Test()
    public void loginTest() throws Exception {      

        WebDriver driver = DriverManager.getDriver();

        // Launch website

        String url = "https://beta.hosttools.com/";
        driver.get(url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        // WebElement loginBtn = driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
        // loginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login')]")))
            .click();

        // hardwait (5s)

        WebElement loginBtn = driver.findElement(By.xpath("//*[contains(text(),'Login1')]"));
        loginBtn.click();
        
        Utils.hardWait();
        
    }

}