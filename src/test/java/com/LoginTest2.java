package com;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest2 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {




        // Launch website
        String url = "https://automationtestpro.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}
