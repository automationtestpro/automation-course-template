package com.pages;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public WebDriver driver;

    protected BasePage(WebDriver givenDriver){
        this.driver = givenDriver;
    }

    public WebElement findElement(By by) {
        System.out.println("here3");
        return driver.findElement(by);
    }

}
