package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai19 extends BasicTest {
    @Test(dataProvider = "testLogin")
    public void loginTest(String username, String pwd) throws Exception {

        //Get element
        WebElement account = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(), 'Log in ')]"));

        account.clear();
        account.sendKeys(username);
        password.clear();
        password.sendKeys(pwd);
        btnLogin.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
