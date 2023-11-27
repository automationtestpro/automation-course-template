package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.config.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    // private String driverPath;

    @BeforeMethod
    public void preCondition() throws MalformedURLException {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);



        if (Constants.BROWSER.equals("chrome")){


            // Lambdatest hub url
            String hubURL = "https://hub.lambdatest.com/wd/hub";

            // Copied from Lambda Test
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "120.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "duykhanhrc");
            ltOptions.put("accessKey", "gdU41M1Duhrjy7jviKfpCInWZC8ZJMt6fk0sn2a0KlV5Qn7Y81");
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("project", "Untitled");
            capabilities.setCapability("LT:Options", ltOptions);

            // Init remote driver
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);

        } else if (Constants.BROWSER.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else 

        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

        
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}