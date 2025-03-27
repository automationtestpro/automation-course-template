package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public Actions actions;

    public BasePage(WebDriver givenDriver) { // constructor
        this.driver = givenDriver;
        this.actions = new Actions(driver);
        PageFactory.initElements(this.driver, this);
    }
}
