package com.pages;

import org.openqa.selenium.WebDriver;





public class BasePage {
    

    protected WebDriver driver;
    public WebDriver WebDriverWait;
    // private String driverPath;

    public BasePage (WebDriver givendriver){
        this.driver = givendriver;
    }
}