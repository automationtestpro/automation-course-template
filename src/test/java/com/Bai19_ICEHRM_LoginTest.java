package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;


public class Bai19_ICEHRM_LoginTest extends BasicTest {


    @DataProvider(name = "testDataFeed")

    public Object[][] testDataFeed() {

         return new Object[][]{

            {"admin", "admin", false},
            {"admin", "admin123",true},
            
         };
    }

    @Test(dataProvider = "testDataFeed")

    public void LoginTest(String userName, String passWord, boolean expectedMesageErrorDisplay) throws Exception {
        // Mở trang đăng nhập
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Nhập email và pass
        waitElementVisible("//input[@id='username']").sendKeys(userName);
        waitElementVisible("//input[@id='password']").sendKeys(passWord);

         //Click nút đăng nhập
        waitElementClickable("//button[normalize-space()='Log in']").click();
        
        if(expectedMesageErrorDisplay == false){
            // Login thành công: Mất nút login
            waitElementVisible("//a[contains(text(),'Employees') or contains(text(),'Dashboard')]");
            System.out.println("Login success");
        } else {
            // Login Fail: show error
            WebElement errorMessageText = waitElementVisible("//div[@class='alert alert-danger']");
            Assert.assertTrue(errorMessageText.getText().contains("Login failed"));
        }
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