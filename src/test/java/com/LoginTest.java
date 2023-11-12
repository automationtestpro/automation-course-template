package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BasicTest {


    @Test(dataProvider = "loginAccounts")
    public void loginTest(String uname, String password)  {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        WebElement emailEle = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        emailEle.sendKeys(uname);

        // Pass
        WebElement passEle = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passEle.sendKeys(password);

        // Login
        WebElement loginEle = driver.findElement(By.xpath("(//*[contains(text(),\"Đăng nhập\")])[4]"));
        loginEle.click();

        Utils.hardWait(); // 3s


        Assert.assertFalse(loginEle.isDisplayed());

    }

    @DataProvider(name="loginAccounts")
    public Object[][] testData() {
        Object[][] data = new Object[3][2];

        data[0][0] = "testtest1@gmail.com";
        data[0][1] = "testtest1";

        data[1][0] = "testtest2@gmail.com";
        data[1][1] = "testtest2";

        data[2][0] = "testtest3@gmail.com";
        data[2][1] = "testtest3";


        return data;

    }

}
