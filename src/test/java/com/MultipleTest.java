package com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.config.Constants;
import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MultipleTest extends BasicTest {
    
    
    
    @Test()
    public void hoverTest() throws Exception {

        // Launch website
        String url = Constants.HOMEPAGE_URL; // Use the URL from Constants class
        driver.get(url);
        Utils.hardWait(3000); // Wait for 3 seconds to ensure the page is loaded

        // Get all new products
        List<WebElement> newProducts = driver.findElements(By.xpath("//section[@id='eweb_new_product-2']//div[@class=\"item-product\"]"));
        
        for (WebElement product : newProducts) {
            String productName = product.findElement(By.xpath(".//a[contains(@class,'product-title')]")).getText();
            System.out.println("New Product: " + productName);
        }
        
        int actualCount = newProducts.size();
        int expectedCount = 7; // Expected number of new products
        Assert.assertEquals(actualCount, expectedCount, "The number of new products does not match the expected count: " + expectedCount);
        

    }



}
