package com;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

//import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.BannerPage;
import com.pages.CollectionDetails;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai26_sammishopTest extends BasicTest {


    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://tiki.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        Utils.hardWait(3000);
        

        // check banner is displayed
        // if display -> close banner
        // if not -> nothing

        boolean isBannerDisplayed = isElementDisplayed(By.id("VIP_BUNDLE"));
        if (isBannerDisplayed) {
            driver.findElement(By.xpath("//img[@alt='close-icon']")).click();
        }
        // steps
   
    }
    
    public boolean isElementDisplayed(By byElement){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }


    public String getErrorMessage(By byElementLocator){
        try {
            WebElement element = driver.findElement(byElementLocator);
            return element.getText();
        } catch (Exception e) {
            return "";
        }
    }
}