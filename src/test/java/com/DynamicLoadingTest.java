package com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class DynamicLoadingTest extends BasicTest {


    @Test()
    public void exampleTest() throws Exception {

        WebDriver driver = threadLocalDriver.get();
        
        // Launch website
        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);
        Utils.hardWait();

        // Click on the start button
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();
        Utils.hardWait();
        // Wait for the loading to complete
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        Utils.hardWait();
        // Verify the text
        WebElement finishText = driver.findElement(By.id("finish"));
        String text = finishText.getText();
        Assert.assertTrue(text.contains("Hello World!"), "Text not found!");
        Utils.hardWait();
        
        


        
























        
    }

}
