package com.utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    private static final Duration TIMEOUT = Duration.ofSeconds(20); 
    
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

    public static void newtab(WebDriver driver, String url) {
    String oldTab = driver.getWindowHandle();

    // Mở tab mới
    ((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank');");

    // Switch sang tab mới
    Set<String> allTabs = driver.getWindowHandles();
    for (String handle : allTabs) {
        if (!handle.equals(oldTab)) {
            driver.switchTo().window(handle);
            break;
        }
    }

    // Chờ tab mới load
    WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Đăng nhập']")));
    }
}