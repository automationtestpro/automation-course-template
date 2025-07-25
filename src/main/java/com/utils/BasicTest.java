package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    // private String driverPath;

    @BeforeMethod
    // @Parameters({"browser"})
    public void setup() {
        // Chromedriver path

        String browser = "chrome";

        // If execting = LOCAL
        // // headless mode
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        // options.addArguments("--disable-gpu");
        // options.addArguments("--window-size=1920,1080");

        // if (browser.equalsIgnoreCase("chrome")) {
        //     WebDriverManager.chromedriver().setup();
        //     driver = new ChromeDriver(options);
        // } else if (browser.equalsIgnoreCase("edge")) {
        //     WebDriverManager.edgedriver().setup();
        //     driver = new EdgeDriver();
        // } else {
        //     throw new IllegalArgumentException("Browser not supported: " + browser);
        // }

        /// ELSE

        // String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        // String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        // ;
        // String hub = "@hub.lambdatest.com/wd/hub";

        // DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("platform", "MacOS Catalina");
        // caps.setCapability("browserName", "Safari");
        // caps.setCapability("version", "latest");
        // caps.setCapability("build", "TestNG With Java");
        // caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        // caps.setCapability("plugin", "git-testng");

        // String[] Tags = new String[] { "Feature", "Falcon", "Severe" };

        // caps.setCapability("tags", Tags);

        // driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 15);

        actions = new Actions(driver);
    }

    @AfterMethod
    public void teardown(){
        // Quit the Browser
        driver.quit();
    }
}