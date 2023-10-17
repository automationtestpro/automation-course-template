package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.config.Constants;
import com.github.dockerjava.api.model.Capability;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
        // driver = new ChromeDriver(options);

        if (Constants.BROWSER_TYPE.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Constants.BROWSER_TYPE.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (Constants.BROWSER_TYPE.equals("chrome_remote")) {
            String Grid_url  = "http://192.168.1.4:4444";
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();

            desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

            driver = new RemoteWebDriver(new URL(Grid_url), desiredCapabilities);
        }

        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}