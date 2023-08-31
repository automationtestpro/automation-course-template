package com.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.config.Constants;

import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.net.URL;

public enum BrowserType { 
    CHROME("Chrome") {
        @Override
        public WebDriver createDriver() {
            // Chromedriver path
            driverPath = System.getProperty("user.dir") + File.separator +
            "src/main/resources/WebDrivers/"+forMacUserOrWindows("chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver(options);
            // Maximize the browser
            driver.manage().window().maximize();

            return driver;
        }

        @Override
        public WebDriver createRemoteDriver() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
            
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = rWebDriver(capabilities);

            return driver;
        }
    },
    EDGE("Edge") {
        @Override
        public WebDriver createDriver() {
            driverPath = "src/main/resources/WebDrivers/msedgedriver.exe";
            EdgeOptions options = new EdgeOptions();
            System.setProperty("webdriver.edge.driver", driverPath);
            driver = new EdgeDriver(options);
            // Maximize the browser
            driver.manage().window().maximize();

            return driver;
        }

        @Override
        public WebDriver createRemoteDriver() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            EdgeOptions options = new EdgeOptions();
            
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = rWebDriver(capabilities);

            return driver;
        }
    },
    ANDROID("Android") {
        @Override
        public WebDriver createDriver() {
            //String appLocation = System.getProperty("user.dir") + File.separator + "src/main/resources/apps" + File.separator + "AndroidDemo.apk";
            //appLocation = FileManager.slashen(appLocation, "backwards");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            // capabilities.setCapability("platformVersion", "8.1");
            // capabilities.setCapability("deviceName", "Pixel_2_XL_API_27");
            //capabilities.setCapability("app", appLocation);
            // //capabilities.setCapability("appPackage", "io.appium.android.apis");
            // //capabilities.setCapability("appActivity", ".view.TextFields");
            // capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
            // capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
            // // capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
            // // capabilities.setCapability("appWaitForLaunch", false);
            // capabilities.setCapability("automationName", "UiAutomator2");
            // // capabilities.setCapability("udid", "emulator-5554");

            try {
                //driver = new AndroidDriver<>(AppiumDriverLocalManager.getServiceUrl(), capabilities);
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (Exception e) {
                System.out.println("Driver error!");
                System.out.println(e.getMessage());
            }

            return driver;
        }

        @Override
        public WebDriver createRemoteDriver() {
            // String appLocation = Constants.Apps_Path + File.separator + "AndroidDemo.apk";
            // appLocation = FileManager.slashen(appLocation, "backwards");
            // DesiredCapabilities capabilities = new DesiredCapabilities();
            // capabilities.setCapability("platformName", "Android");
            // capabilities.setCapability("platformVersion", "8.1");
            // capabilities.setCapability("deviceName", "Pixel_2_XL_API_27");
            // capabilities.setCapability("app", appLocation);
            // capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
            // capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
            // capabilities.setCapability("automationName", "UiAutomator2");
            // // capabilities.setCapability("udid", "emulator-5554");

            // driver = rAndroidDriver(capabilities);

            return driver;
        }
    };

    private final String deviceName;

    BrowserType(String deviceName) {
        this.deviceName = deviceName;
    }

    private static WebDriver rWebDriver(DesiredCapabilities capabilities) {
        try {
            driver = new RemoteWebDriver(new URL(gridURL), capabilities);
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Driver error!");
            System.out.println(e.getMessage());
        }

        return driver;
    }

    private static String forMacUserOrWindows(String driverName) {       
        if(OS.indexOf("mac") >= 0){
            return driverName;
        }
        return driverName + ".exe";
    }

    static WebDriver driver;
    static final String OS = System.getProperty("os.name").toLowerCase();
    static private String driverPath;
    static String gridURL = String.format("http://%s/wd/hub", Constants.Grid_Url);

    public abstract WebDriver createDriver();

    public abstract WebDriver createRemoteDriver();
}