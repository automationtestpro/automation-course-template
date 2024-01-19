package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai18 extends BasicTest {


    @Test()
    public void bai18() throws Exception {
        // Launch website
        String url = "https://automationtestpro.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
