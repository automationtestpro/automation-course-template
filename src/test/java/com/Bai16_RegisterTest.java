package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;


public class Bai16_RegisterTest extends BasicTest {

    @Test()
    public void registerTest() throws Exception {
        // Mở trang đăng ký
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Nhập email
        waitElementVisible("//input[@id='reg_email']")
        .sendKeys("testtest@gmail.com");
        // Để trống password
         waitElementVisible("//input[@id='reg_password']").sendKeys("");
         // Nhấn nút đăng ký
       waitElementClickable("//button[@name='register']").click();

        // Kiểm tra lỗi
        WebElement errorrMessageText = waitElementVisible(By.xpath("//ul[@class='woocommerce-error']/li"));
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
