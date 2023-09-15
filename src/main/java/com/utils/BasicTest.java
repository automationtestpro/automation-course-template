package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public abstract class BasicTest {

    protected static WebDriver driver;

    // private String driverPath;

    @BeforeMethod
    public void preCondition() {
        //  Chromedriver path

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
        options.addArguments("--no-sanbox");
        options.addArguments("--disabled-dev-shm-usage");
        driver = new ChromeDriver(options);


        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @AfterMethod
    public void postCondition() {
        // Quit the Browser
        driver.quit();
    }
}