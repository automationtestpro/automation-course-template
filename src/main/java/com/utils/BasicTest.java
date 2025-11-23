package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.Arrays;
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
        
        String browser = Constants.browser;
        
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            
            // 🚀 THÊM CÁC TÙY CHỌN ẨN DANH ĐỂ VƯỢT QUA CAPTCHA
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            
            //headless mode
            if (Constants.headless){
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
            }
            // options
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


        // Dimension targetSize = new Dimension(1366, 768);
        // driver.manage().window().setSize(targetSize);
        // 🚀 Đặt lại thời gian chờ mặc định (Thường là 10 giây là đủ)
        wait = new WebDriverWait(driver, Duration.ofSeconds(25)); 
                        // add driver action
        action = new Actions(driver);

    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        //driver.quit();
    }


    /**
     * Phương thức chờ phần tử hiển thị (Visibility)
     * @param by Đối tượng By (xpath, id, css,...) của phần tử
     * @return WebElement đã hiển thị
     */
    protected WebElement waitElementVisible(By by) {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    /**
     * Phương thức chờ phần tử hiển thị (Visibility) bằng chuỗi XPath
     * @param xpathLocator Chuỗi XPath
     * @return WebElement đã hiển thị
     */
    protected WebElement waitElementVisible(String xpathLocator) {
       return waitElementVisible(By.xpath(xpathLocator));
    }
    
    /**
     * Phương thức chờ phần tử có thể click (Clickable)
     * @param by Đối tượng By (xpath, id, css,...) của phần tử
     * @return WebElement đã sẵn sàng để click
     */
    protected WebElement waitElementClickable(By by) {
       return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    
    /**
     * Phương thức chờ phần tử có thể click (Clickable) bằng chuỗi XPath
     * @param xpathLocator Chuỗi XPath
     * @return WebElement đã sẵn sàng để click
     */
    protected WebElement waitElementClickable(String xpathLocator) {
       return waitElementClickable(By.xpath(xpathLocator));
    }

    /**
     * Phương thức chờ phần tử hiện diện trong DOM (Presence) dựa trên đối tượng By.
     * (Phần tử có thể chưa hiển thị, nhưng đã có trong cấu trúc HTML).
     * @param by Đối tượng By (xpath, id, css,...) của phần tử.
     * @return WebElement đã hiện diện.
     */
    protected WebElement waitElementPresent(By by) {
       return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Phương thức chờ phần tử hiện diện trong DOM (Presence) dựa trên chuỗi XPath.
     * @param xpathLocator Chuỗi XPath.
     * @return WebElement đã hiện diện.
     */
    protected WebElement waitElementPresent(String xpathLocator) {
       return waitElementPresent(By.xpath(xpathLocator));
    }
    protected boolean waitTextPresentInElement(By by, String text) {
    return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
}
    
    /**
     * Phương thức chờ cho văn bản cụ thể xuất hiện trong phần tử được xác định bằng XPath.
     * @param xpathLocator Chuỗi XPath.
     * @param text Văn bản mong muốn xuất hiện trong phần tử.
     * @return boolean true nếu văn bản xuất hiện, ngược lại là false.
     */
    protected boolean waitTextPresentInElement(String xpathLocator, String text) {
       return waitTextPresentInElement(By.xpath(xpathLocator), text);
    }
    
    /**
     * Phương thức chờ cho giá trị thuộc tính (attribute value) cụ thể của phần tử.
     * @param by Đối tượng By của phần tử.
     * @param attribute Thuộc tính cần kiểm tra (ví dụ: "class", "value", "id").
     * @param value Giá trị mong muốn của thuộc tính.
     * @return boolean true nếu giá trị thuộc tính khớp, ngược lại là false.
     */
    protected boolean waitAttributeValue(By by, String attribute, String value) {
       return wait.until(ExpectedConditions.attributeToBe(by, attribute, value));
    }
    
    /**
     * Phương thức chờ cho giá trị thuộc tính (attribute value) cụ thể của phần tử bằng XPath.
     * @param xpathLocator Chuỗi XPath.
     * @param attribute Thuộc tính cần kiểm tra.
     * @param value Giá trị mong muốn của thuộc tính.
     * @return boolean true nếu giá trị thuộc tính khớp, ngược lại là false.
     */
    protected boolean waitAttributeValue(String xpathLocator, String attribute, String value) {
       return waitAttributeValue(By.xpath(xpathLocator), attribute, value);
    }


    // hàm chờ
    protected boolean isElementDisplayedQuickly(By by, int timeoutInSeconds) {
        try {
            // Tạo WebDriverWait cục bộ với timeout ngắn hơn
            WebDriverWait quickWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            
            // Chờ phần tử hiển thị và kiểm tra isDisplayed()
            return quickWait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
            
        } catch (Exception e) {
            // Bắt TimeoutException (và các Exception khác) và trả về false
            return false;
        }
    }
}