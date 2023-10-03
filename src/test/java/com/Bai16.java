package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai16 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        logger.info("Start test Bai16");
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        logger.info("Url: " + url);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}