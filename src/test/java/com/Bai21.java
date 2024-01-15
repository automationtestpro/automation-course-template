package com;

import com.utils.BasicTest;
import com.utils.DriverManager;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Bai21 extends BasicTest {

    @Test()
    public void bai16() {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/";

        WebDriver driver = DriverManager.getDriver();

        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Đăng nhập')]")));

        Actions action = new Actions(driver);


        WebElement dnBtn = driver.findElement(By.xpath("//strong[contains(text(),'Đăng nhập')]"));
        action.moveToElement(dnBtn).perform();


        wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Đăng ký tại đây.')]")))
            .click();


        
        Utils.hardWait();





    }
}