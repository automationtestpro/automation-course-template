package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bai17 {

    protected static WebDriver driver;

    @Test()
    public void loginTest() throws Exception {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement email= driver.findElement(By.xpath("//*[@id='username']"));
        email.sendKeys("duykhanhrc@gmail.com");
        WebElement pass= driver.findElement(By.xpath("//*[@id='password']")); 
        pass.sendKeys("123456");
        WebElement click=driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/button"));
        click.click();
        WebElement thoat=driver.findElement(By.xpath("//*[@id='main']/section[2]/div/div/div/div/div/div/div/div/nav/ul/li[6]/a"));
        thoat.click();
        driver.navigate().back();
        Utils.hardWait(5000);
        WebElement tk=driver.findElement(By.xpath("//*[@id='main']/section[2]/div/div/div/div/div/div/header/h1"));
        Assert.assertFalse(tk.isDisplayed());
        // Quit the Browser
        driver.quit();
    }

    
}
