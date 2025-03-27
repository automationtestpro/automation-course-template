package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21_HoverTest extends BasicTest {
    
    @Test()
    public void loginTest() throws Exception {



        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        HomePage homePage = new HomePage(driver);

        Utils.hardWait(2000); // 2s

        // WebElement menu1 = driver.findElement(By.xpath("//a[contains(text(),'Hệ thống truyền động, Khung gầm')]"));

        // actions.moveToElement(menu1).perform();
        homePage.hoverMenu1();

        Utils.hardWait(); // 3s


        //tr[contains(@class,'cart_item')]

    }

   
}
