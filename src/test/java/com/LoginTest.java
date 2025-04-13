package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginExampleTest() throws Exception {
        // Launch website
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        Utils.hardWait();

        driver.get("https://automationtestpro.com/");
        Utils.hardWait();

        driver.navigate().back();
        Utils.hardWait();

        driver.navigate().forward();
        Utils.hardWait();
        
        driver.navigate().refresh();
        Utils.hardWait();




















        
    }

}
