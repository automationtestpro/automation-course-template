package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai22 extends BasicTest {
    @Test()
    public void loginTesst() throws Exception {
        HomePage homepage = new HomePage(driver);
        homepage.open();
        Utils.hardWait();
        homepage.login();
        Utils.hardWait();
        WebElement xpathtext = driver.findElement(By.xpath("//input[@name='PasswordDN']"));
        By passtext = By.xpath("//input[@name='PasswordDN']");
        homepage.verifyLogin("test1234@gmail.com", "");
        String toolTipText = xpathtext.getAttribute("validationMessage");
        System.out.println("Thông báo từ thuộc tính validationMessage: " + toolTipText);
        String nameMessage = getHTML5ValidationMessage(driver.findElement(passtext));
        System.out.println("Thông báo từ hàm getHTML5ValidationMessage: " + nameMessage);
        Assert.assertEquals("Please fill out this field.", nameMessage);
        Utils.hardWait();
        //homepage.verifyLogin("test1234@gmail.com", "123456");
    }

    // @Test()
    // public void tc02() throws Exception {
    //     HomePage homepage = new HomePage(driver);
    //     homepage.open();
    //     homepage.login();
    //     Utils.hardWait();
    //     homepage.verifyLogin("test1234@gmail.com", "123456");
    //     Utils.hardWait();
    // }

    public String getHTML5ValidationMessage(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

}
