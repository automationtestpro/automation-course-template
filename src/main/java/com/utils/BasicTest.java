package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    private String driverPath;

    @BeforeMethod
    public void preCondition() {
        // Chromedriver path
        driverPath = "src/main/resources/WebDrivers/chromedriver";
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
        // WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}