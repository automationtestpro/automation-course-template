package com.utils;

import java.sql.DriverManager;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static void hardWait(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            // pass
        }
    }

    public static void hardWait(){
        hardWait(3000);
    }

    public static void newTab(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open()");
        hardWait(500);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}
