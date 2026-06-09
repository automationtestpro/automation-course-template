package com.src.test.java.com.ui;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest2 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {

        // Launch website
        driver.get(this.url);
        Assert.assertEquals(driver.getCurrentUrl(), this.url);
        Utils.hardWait();

    }

}
