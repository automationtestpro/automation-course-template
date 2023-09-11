package com.utils;

import com.config.Constants;
import com.driver.DriverManager;
import com.driver.LaunchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import org.testng.annotations.Listeners;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class BaseTest {

    //protected static WebDriver driver;
    public static final Logger logger = LogManager.getLogger("EAT");

    // public static WebDriver getDriver() {
    //     return driver;
    // }

    @BeforeMethod
    @Parameters(value={"browser"})
    public void preCondition(@Optional(Constants.BROWSER_TYPE) String browser) {
        WebDriver driver = LaunchBrowser.getDriver(browser);
        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        DriverManager.quit();
    }
}