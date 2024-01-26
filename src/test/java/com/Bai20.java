package com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai20 extends BasicTest {
    @Test(dataProvider = "testLogin")
    public void loginTest(String username, String pwd) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Get element
        //WebElement account = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        //WebElement password = driver.findElement(By.id("password"));
        //WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(), 'Log in ')]"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(pwd);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Log in ')]"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
