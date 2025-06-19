package com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.config.Constants;
import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HoverTest extends BasicTest {
    
    
    
    @Test()
    public void hoverTest() throws Exception {

        // Launch website
        String url = Constants.URL; // Use the URL from Constants class
        driver.get(url);

        // Hover to element 1
        // WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hệ thống truyền động, Khung gầm')]")));
        
        // actions.moveToElement(hoverElement).perform();
        // Utils.hardWait(3000); // Wait for 1 second to simulate hover action
        hoverToMenu("Hệ thống truyền động, Khung gầm 1312313");


        // Hover to element 2
        // WebElement hoverElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hệ thống phanh')]")));
        // actions.moveToElement(hoverElement2).perform();
        // Utils.hardWait(3000); // Wait for 1 second to simulate hover action
        hoverToMenu("Hệ thống phanh");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Phanh sau ô tô')]"))).click();
        Utils.hardWait(3000); // Wait for 3 seconds to ensure the click action is processed
        

        

    }

    public void hoverToMenu(String menuText) {

            //dynamic locator
            String dynamicLocator = "//*[contains(text(),'" + menuText + "')]";
        
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
            actions.moveToElement(element).perform();
            Utils.hardWait(3000); // Wait for 1 second to simulate hover action
    }


}
