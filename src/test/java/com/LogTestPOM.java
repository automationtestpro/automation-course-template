package com;

import baseTest.AbstractTest;
import baseTest.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogTestPOM  extends BasicTest {
    LoginPage loginPage;


    @Test()
    public void loginTest() throws Exception {

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        loginPage = new LoginPage(driver);
        loginPage.openUrl(url);
        Assert.assertEquals(loginPage.getCurrentUrl(), url);
        loginPage.clickRegister();
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectEmailError ="Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(actualErrorMessage,expectEmailError);

        loginPage.inputEmail("123$123");
        loginPage.clickRegister();
        String actualErrorMessage2 = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage2,expectEmailError);


        loginPage.inputEmail("khoa@gmail.com");
        loginPage.clickRegister();
        String actualErrorMessage3 = loginPage.getErrorMessage();
        String expectErrorText ="Lỗi: Vui lòng nhập mật khẩu tài khoản.";
        Assert.assertEquals(actualErrorMessage3,expectErrorText);

    }
}

