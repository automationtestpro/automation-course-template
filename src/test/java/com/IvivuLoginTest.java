package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.IvivuLoginPage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class IvivuLoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        // WebElement tk= driver.findElement(By.xpath("//li[@id=\"UserLogin\"]"));
        // tk.click();

        // Utils.hardWait();

        // WebElement dn= driver.findElement(By.xpath("(//li[@class=\"btn-login-wrap\"])[1]"));
        // dn.click();

        // Utils.hardWait();

        // WebElement email= driver.findElement(By.xpath("//input[@name='EmailPhoneDN']"));
        // email.sendKeys("duykhanhrc@gmail.com");

        

        // WebElement password= driver.findElement(By.xpath("//input[@name='PasswordDN']"));
        // password.sendKeys("123456");


        // WebElement login= driver.findElement(By.xpath("(//button[contains(@class,\"btn-login\")])[1]"));
        // login.click();

        // WebElement logo= driver.findElement(By.xpath("//span[@class=\"username-header\"]"));
        


        // Ctrl + /

        IvivuLoginPage loginPage = new IvivuLoginPage(driver);
        // loginPage.openDn();
        // loginPage.enterEmail("duykhanhrc@gmail.com");
        // loginPage.enterPass("123456");
        // loginPage.clickLogin();

        loginPage.openDn()
            .enterEmail("duykhanhrc@gmail.com")
            .enterPass("123456")
            .clickLogin();


        WebElement logo= driver.findElement(By.xpath("//span[@class=\"username-header\"]"));
        Assert.assertTrue(logo.isDisplayed()); //tmp check...



    }

}
