package com;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class Bai19 extends BasicTest {

    /**
         * @param id
         * @param password
         */
    @Test(dataProvider = "testdata")
    public void signupTest(String id, String password) {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(id);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='loginForm']//button"))).click();
        try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-circle text-success']")));

        } catch (NoSuchElementException e) {
            System.out.println("The 'Logged in' status could not be found.");
        }
    }

    @DataProvider(name="testdata")
    public Object[][] logindata(){
        return new Object[][]
        {
            {"admin","admin"},
            {"manager","demouserpwd"},
            {"user1","demouserpwd"},
            {"user2","demouserpwd"}
        };
    }

}