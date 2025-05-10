package com;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import javax.ws.rs.ext.Provider;

import org.aspectj.apache.bcel.classfile.Module.Open;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.utils.Utils;
import com.utils.BasicTest;

import io.appium.java_client.android.nativekey.KeyEvent;

public class Bai19_ICEHRM_LoginTest extends BasicTest {
    
    @DataProvider(name="testDataFeed")
    public Object [][] dataLogin()
    {
       Object[][] data= new Object[5][3] ;

       data[0][0] = "admin" ;
       data[0][1] = "admin";
       data[0][2] = "";

       data[1][0] = "admin" ;
       data[1][1] = "admin123";
       data[1][2] = "Login failed";

       data[2][0] = "manager" ;
       data[2][1] = "demouserpwd";
       data[2][2] = "";

       data[3][0] = "user1" ;
       data[3][1] = "demouserpwd";
       data[3][2] = "";

       data[4][0] = "user2" ;
       data[4][1] = "demouserpwd";
       data[4][2] = "";
      
       return data;
    }

    @Test(dataProvider = "testDataFeed")
    public void loginTest(String name,String pass,String Expected) throws Exception
    {
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(); // cho 3s

        //username
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys(name);
        Utils.hardWait(); // cho 3s
        //pass
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(pass);
        Utils.hardWait(); // cho 3s

        //CLick
        Utils.hardWait(3);
        WebElement click=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        click.click();

        String errormessageText = getError();
        Assert.assertEquals(errormessageText, Expected);

    }

    public String getError()
        {
            try{
                WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            return errorMessage.getText();
            }catch(Exception e)
            {
                System.out.println("Login button not found ne");
                return "";
            }

        }
}
