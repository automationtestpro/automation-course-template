package com;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.aspectj.apache.bcel.classfile.Module.Open;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.utils.Utils;

import io.appium.java_client.android.nativekey.KeyEvent;

import com.utils.BasicTest;


public class Bai18_TabTest extends BasicTest {
    @Test()
    public void  tabTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
       
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait();
        //email
        WebElement email=driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("thanhvinh231198@gmail.com");

        //pass
    Utils.hardWait();
        WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("Vinhkute98@");
        //CLickbtn
        Utils.hardWait(3);
        WebElement click=driver.findElement(By.xpath("//button[@name='login']"));
        click.click();
        WebElement content=driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
        Assert.assertTrue(content.getText().contains("thanhvinh231198"));
       
        Utils.hardWait(5000);
         
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank','_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
      
        driver.switchTo().window(tabs.get(1));
        String url1="https://bantheme.xyz/hathanhauto/";
        driver.get(url1);
        Assert.assertEquals(driver.getCurrentUrl(), url1);
    
        Utils.hardWait(5000);
        driver.switchTo().window(tabs.get(0));
        driver.close();
        Utils.hardWait(5000);
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Utils.hardWait(5000);
         //clicklogin
     WebElement clicklogin=driver.findElement(By.xpath("//strong[@class='block']"));
         clicklogin.click();
         WebElement content1=driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
         Assert.assertTrue(content1.getText().contains("thanhvinh231198"));
         
    }
}
