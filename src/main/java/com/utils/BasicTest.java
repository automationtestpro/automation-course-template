package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.config.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    // protected static WebDriver driver;
    // private String driverPath;

    @BeforeMethod
    // @Parameters({"baseURL"})
    public void preCondition() {

        if (Constants.BROWSER_TYPE.equalsIgnoreCase("chrome")) {
            // Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920,1080");
            options.addArguments("--no-sanbox");

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(options);
            // set to thread local
            DriverManager.setDriver(driver);
        } else if (Constants.BROWSER_TYPE.equalsIgnoreCase("firefox")) {    
            // Firefox
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            // set to thread local
            DriverManager.setDriver(driver);
        } else {
            // TODO:
        }

        // Safari

        // MS Edge



        // Maximize the browser
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();

        // // Launch website
        // String url = baseUrl;
        // driver.get(url);
        // Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        //driver.quit();
        DriverManager.quit();
    }
}