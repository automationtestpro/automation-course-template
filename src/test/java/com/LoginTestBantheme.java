package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTestBantheme extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys("abc@gmail.com");

        WebElement passwordInp = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInp.sendKeys("123456");


        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button"));
        loginBtn.click();

        Assert.assertFalse(loginBtn.isDisplayed());

        Utils.hardWait(5000);

    
        Assert.assertEquals(passwordInp.getText(), "error 1234");



        loginBtn.click();

        Assert.assertEquals(passwordInp.getText(), "error 1234");

        abc.click();
//dasdasdas
        Assert.assertEquals(passwordInp.getText(), "error 1234");

    }

}
