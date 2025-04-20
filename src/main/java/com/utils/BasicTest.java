package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeMethod
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        threadLocalDriver.set(driver);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        threadLocalDriver.get().quit();
        threadLocalDriver.remove();
    }
}