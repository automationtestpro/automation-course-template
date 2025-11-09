package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Parameters;
import org.openqa.selenium.edge.EdgeDriver;



public class  BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    // private String driverPath;

    @BeforeMethod
    public void preCondition() {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
       
       
        String browser = Constants.browser;

        if(browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
        }
        

    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }

 
    //chờ element hiển thị
    protected WebElement waitElementVisible(By by) {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
     protected WebElement waitElementVisible(String xpathLocator) {
       return waitElementVisible(By.xpath(xpathLocator)); 
    }
    
         
    protected WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    protected WebElement waitForElementVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Chờ element có thể click
     protected WebElement waitElementClickable(By by) {
       return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected WebElement waitElementClickable(String xpathLocator) {
       return waitElementClickable(By.xpath(xpathLocator)); 
      }
    
    protected WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    
    protected WebElement waitForElementClickable(String xpathLocator) {

        return waitForElementClickable(By.xpath(xpathLocator)); 
    }

    //Chờ element hiển thị lại sau refresh
    protected WebElement waitForElementRefreshed(WebElement element) {
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
    
    protected WebElement waitForElementRefreshed(By by) {
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
    }
}
