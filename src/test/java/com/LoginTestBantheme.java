package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTestBantheme extends BasicTest {


    @Test(dataProvider = "testdatedemo")
    public void loginTest(String username, String pass) throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys(username);

        WebElement passwordInp = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInp.sendKeys(pass);


        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button"));
        loginBtn.click();

        Assert.assertTrue(loginBtn.isDisplayed());

    }

    @DataProvider(name="testdatedemo")
    public Object[][] TestData(){
        Object[][] testdata = new Object[3][2];
        testdata[0][0] = "u1@gmail.com";
        testdata[0][1] = "p1";

        testdata[1][0] = "u2@gmail.com";
        testdata[1][1] = "p2";

        testdata[2][0] = "u2@gmail.com";
        testdata[2][1] = "p2";


        return testdata;

    }

}
