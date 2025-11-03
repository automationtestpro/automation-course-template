package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;


public class Bai16_LoginTest extends BasicTest {


    @DataProvider(name="SuccessLogin")
        public Object[][] SuccessLogin() {
        return new Object[][]{
            {"huadongxuan852@gmail.com", "xuanice123"},

              };
        }

         @DataProvider(name="FailedLogin")
        public Object[][] FailedLogin() {
        return new Object[][]{
             {"huadongxuan852@gmail.com", ""}
              };
        }

    @Test(dataProvider = "SuccessLogin", priority = 1)
    public void loginTestSuccess(String emailInput, String passWord) throws Exception {
        // Mở trang đăng nhập
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        //Nhập email và pass
        waitElementVisible("//input[@id='username']").sendKeys(emailInput);
        waitElementVisible("//input[@id='password']").sendKeys(passWord);

        //Click nút "Đăng nhập"
        waitElementClickable("//button[@name='login']").click();

        // Kiểm đăng nhập thành công (nút login biến mất)
        waitElementVisible("//p[contains(text(), 'Xin chào')]");
        System.out.println("Đăng nhập thành công");
        }


   @Test(dataProvider = "FailedLogin", priority = 2)
    public void loginTestFailed(String emailInput, String passWord) throws Exception{
         // Mở trang đăng nhập
        String url ="https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
       //Nhập email và pass
        waitElementVisible("//*[@id='username']").sendKeys(emailInput);
        waitElementVisible("//*[@id='password']").sendKeys(passWord);
        
         //Click nút đăng nhập
        waitElementClickable("//button[@name='login']").click();

        // Kiểm tra lỗi
         WebElement errorrMessageText = waitElementVisible("//ul[@class='woocommerce-error']/li");
        Assert.assertTrue(errorrMessageText.isDisplayed());

    }

    /*public boolean isElementDisplayed(WebElement element){

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        
    }*/

}

