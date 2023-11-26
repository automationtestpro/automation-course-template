package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    // private String driverPath;

    @BeforeMethod
    public void preCondition() throws MalformedURLException {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        WebDriverManager.chromedriver().setup();

        // setup trên lambda test
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "120.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "hoangtri88888");
        ltOptions.put("accessKey", "s0yD3tCtNK1rvvBQUb3tSLeaYd0voZw6aq4hTcJSUDTMyadIHM");
        ltOptions.put("video", true);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("build", "bai25");
        ltOptions.put("project", "test on lambda");
        ltOptions.put("name", "bai25");
        capabilities.setCapability("LT:Options", ltOptions);

        // phải dùng remote driver của lambda, ko dùng driver của local
        driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        //driver = new ChromeDriver();
        // Maximize the browser
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}