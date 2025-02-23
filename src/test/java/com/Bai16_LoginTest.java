package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_LoginTest extends BasicTest {
    
    @Test(dataProvider = "loginData")
    public void loginTest(String uname, String pass, String expected, String errorMessage) throws Exception {

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        Utils.hardWait(2000); // 2s

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys(uname);

        Utils.hardWait(2000); // 2s

        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        passField.sendKeys(pass);

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        Utils.hardWait(2000); // 2s

        if (expected.equals("success")) {
            WebElement loginSuccess = driver.findElement(By.xpath("//li[contains(@class,'logout')]//a"));
            Assert.assertEquals(loginSuccess.getText(), "Thoát");
        } else {
            WebElement ErrorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
            Assert.assertEquals(ErrorMessage.getText(), errorMessage);
        }

        

    }

    // @Test()
    // public void loginTestFail() throws Exception {

    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);

    //     WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
    //     emailField.sendKeys("dunglt.bkhn@gmail.com");

    //     WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
    //     loginButton.click();

    //     WebElement ErrorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
    //     Assert.assertEquals(ErrorMessage.getText(), "Lỗi: Mục nhập mật khẩu trống.");

    // }

    @DataProvider(name = "loginData")
    public Object[][] testdata(){
        Object[][] testDataFeed = new Object[3][4];

        testDataFeed[0][0] = "dunglt.bkhn@gmail.com";
        testDataFeed[0][1] = "dung1992@";
        testDataFeed[0][2] = "success";
        testDataFeed[0][3] = "";

        testDataFeed[1][0] = "dunglt.bkhn@gmail.com";
        testDataFeed[1][1] = "";
        testDataFeed[1][2] = "failed";
        testDataFeed[1][3] = "Lỗi: Mục nhập mật khẩu trống.";

        testDataFeed[2][0] = "";
        testDataFeed[2][1] = "testest";
        testDataFeed[2][2] = "failed";
        testDataFeed[2][3] = "Lỗi: Yêu cầu tên tài khoản.";

        return testDataFeed;
    }
}
