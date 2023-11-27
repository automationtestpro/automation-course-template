package com.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setWebdriver(WebDriver givenDriver) {
        DriverManager.driver.set(givenDriver);
    }

    public static void quit(){
        DriverManager.driver.get().quit();
        driver.remove();
    }
}
