package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai19_LoginTest extends BasicTest {


    @DataProvider(name = "loginData")
    public Object[][] testdata(){
        Object[][] data = new Object[4][3];

        data[0][0] = "testtest1@gmail.com";
        data[0][1] = "testtest1";
        data[0][2] = "Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.";
        
        data[1][0] = "";
        data[1][1] = "testtest2";
        data[1][2] = "Lỗi: Yêu cầu tên tài khoản.";

        data[2][0] = "testtest3@gmail.com";
        data[2][1] = "";
        data[2][2] = "Lỗi: Mục nhập mật khẩu trống.";

        data[3][0] = "thanhvinh231198@gmail.com";
        data[3][1] = "Vinhkute98@";
        data[3][2] = "";


        return data;
    }
    
    
    @Test(dataProvider = "loginData")
    public void loginTest(String uname, String pword, String expectedResult) throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        Utils.hardWait(); // cho 3s

        // enter username
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys(uname);

        Utils.hardWait(); // cho 3s

        // enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(pword);

        Utils.hardWait(); // cho 3s

        // click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        Utils.hardWait(); // cho 3s

        // verify login success
        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        String errormessageText = getErrorMessage();
        Assert.assertEquals(errormessageText, expectedResult);
    }

    public String getErrorMessage(){
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
            return errorMessage.getText();
        } catch (Exception e) {
            System.out.println("Login button not found");
            return "";
        }
        
    }


}
