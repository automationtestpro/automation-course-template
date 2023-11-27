package com;

import java.io.File;


// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.utils.BasicTest;
import com.utils.DriverManager;
import com.utils.ExcelUtils;
import com.utils.Utils;

public class Bai21 extends BasicTest {


   
    
    @Test()
    public void loginTest() throws Exception {      

        WebDriver driver = DriverManager.getDriver();

        // Launch website
        // String url = "https://bantheme.xyz/hathanhauto/";
        // driver.get(url);
        // //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Assert.assertEquals(driver.getCurrentUrl(), url);

        HomePage homePage = new HomePage(driver);
        homePage.open();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Đăng nhập')]")));

        WebElement dnEle = driver.findElement(By.xpath("//*[contains(text(),'Đăng nhập')]"));

        // Actions action = new Actions(driver);
        // action.moveToElement(dnEle).perform();
        homePage.hover(dnEle);

        Utils.hardWait();


        // WebElement loginBtn = driver.findElement(By.xpath("//*[contains(text(),'Đăng ký tại đây.')]"));
        // loginBtn.click();
        homePage.login();
        
        Utils.hardWait();
        
    }

}