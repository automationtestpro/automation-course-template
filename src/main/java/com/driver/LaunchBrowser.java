package com.driver;

import org.openqa.selenium.WebDriver;

public class LaunchBrowser {
    static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        driver = BrowserType.valueOf(browser.toUpperCase()).createDriver();

        return driver;
        
    }
}

