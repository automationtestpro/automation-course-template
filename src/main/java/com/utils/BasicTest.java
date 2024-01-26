package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    // private String driverPath;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void preCondition(String BaseURL) {
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
        driver.get(BaseURL);
    }

    @DataProvider(name = "testLogin")
    public Object[][] TestDataFeed() {

        //Create object array 3 rows, 2 columns
        Object[][] testData = new Object[3][2];

        //Data Test
        testData[0][0] = "admin";
        testData[0][1] = "admin";

        testData[1][0] = "manager";
        testData[1][1] = "demouserpwd";
       
        testData[2][0] = "user1";
        testData[2][1] = "demouserpwd";

        return testData;
    }
    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}