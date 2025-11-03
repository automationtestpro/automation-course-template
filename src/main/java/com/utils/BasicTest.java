package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Parameters;
import org.openqa.selenium.edge.EdgeDriver;



    
public abstract class BasicTest {
   
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    //WebDriver driver;
    // private String driverPath;

    /**
     * 
     */
    @BeforeMethod
    //@Parameters({"browser"})
    public void preCondition(){ 
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
         
        String browser = Constants.browser;
        
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(options);
        }
        
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // driver action
        action = new Actions(driver);

    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}