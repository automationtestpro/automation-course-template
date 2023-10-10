package com;

import java.sql.DriverManager;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bai18 {

    protected static WebDriver driver;
    

    private static void hardWait(int i) 
    {
        hardWait(3000);
    }

    @Test()
    public void loginTest() throws Exception {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Launch website
        String url = "https://google.com/";
       
        driver.get(url);    
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeAsyncScript("window.open(\"https://bantheme.xyz/hathanhauto/tai-khoan/\")");
        hardWait(1000);  
        ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); 
        //WebElement email= driver.findElement(By.xpath("//*[@id='username']"));
        //email.sendKeys("duykhanhrc@gmail.com");
        //WebElement pass= driver.findElement(By.xpath("//*[@id='password']")); 
        //pass.sendKeys("123456");
        //WebElement click=driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/button"));
        //click.click();
        //Assert.assertTrue(click.isDisplayed());
        //Utils.Newtab(driver);
        //driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");
        //Utils.hardWait(15000);
        // Quit the Browser
        driver.quit();

    }

   
    
}
