package com;

import com.utils.BasicTest;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Bai20 extends BasicTest {

    @Test()
    public void bai16() {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //TC1: click  submit button
        //WebElement submitBtn = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        //submitBtn.click();
        //driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]")).click();

        // Utils.hardWait(30000); // 30s
        // driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Đăng ký')]")))
            .click();


        //common.findElement();




        // Utils.hardWait(5000); // 5s
        WebElement textInfo = driver.findElement(By.xpath("//div[@id='main']//li[1]"));
        System.out.println(textInfo.getText());
        Assert.assertEquals(textInfo.getText(),"Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");

        
        Utils.hardWait();





    }
}