package com.utils;

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

    public static void Newtab(WebDriver driver) {
    }

}
