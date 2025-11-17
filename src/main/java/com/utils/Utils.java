package com.utils;


import java.io.File; // 
import java.io.IOException;
import org.apache.commons.io.FileUtils; // 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;

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
    public static void takeScreenshot(WebDriver driver, String name) throws IOException {
        // Implementation for taking screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("target/screenshots/" + name + ".png"));
    }

}
